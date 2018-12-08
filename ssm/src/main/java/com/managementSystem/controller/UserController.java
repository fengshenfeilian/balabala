package com.managementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.managementSystem.pojo.Msg;
import com.managementSystem.pojo.Role;
import com.managementSystem.pojo.User;
import com.managementSystem.service.RoleService;
import com.managementSystem.service.UserService;
import com.managementSystem.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
@SessionAttributes("user")//将名为user的属性加入session中，这样保证了session中存在User对象
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    //登陆，插入，更新，上传时，密码进行md5加密
    //md5是单向加密
    //前端完善

    //用户输入校验（前后端）
    //用户操作鉴权

    //登陆用户在前后端的保存和传递

    //用户控制器，实现了返回json和返回jsp的两种方法


    //用户登陆，输入用户id和密码
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String UserLogin(@RequestParam(value = "userId")String userId
            ,@RequestParam(value = "password")String password,Model model,HttpSession session){
        //加入session相关的操作
        //前端传来的密码应该是md5加密后的32位密码
        User user = userService.checkLogin(userId,password);
        if(user != null){
            model.addAttribute("message","登陆成功");
            model.addAttribute("user",user);
            //根据不同角色传入不同属性
            if(user.getRole().getName().equals("admin")){
                //改为传角色名，增强可读性
                List<User> users = userService.getUsersWithRoleByExample("student","","","","");
                model.addAttribute("users",users);
            }
            else if(user.getRole().getName().equals("teacher")){
                //此处应判断密码是否为默认从而跳转到更改密码界面
            }
            else if(user.getRole().getName().equals("student")){
                //此处应判断密码是否为默认从而跳转到更改密码界面
            }
            else{
                model.addAttribute("message","未知用户");
                return "loginError";
            }
            //返回页面直接以用户角色名命名
            return user.getRole().getName()+"Index";
        }

        model.addAttribute("message","用户名或密码错误");
        //此处返回页面待定
        return "loginError";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String UserLogout(HttpSession session,Model model){
        session.invalidate();
        model.addAttribute("message","注销成功");
        //此处返回登录页
        return "loginError";
    }

    //跳转至账户信息更新
    @RequestMapping(value = "/toConfigPage")
    public String toConfigPage(HttpSession session,Model model){
        //User curUser = (User)session.getAttribute("user");
        return "userConfig";
    }
    //跳转至用户插入
    @RequestMapping(value = "/toAdminInsertPage", method = RequestMethod.GET)
    public String toInsertPage(@RequestParam(value = "roleName")String roleName,HttpSession session,Model model){
        List<Role> roles = roleService.getRoleByName(roleName);
        if(roles!=null)
            model.addAttribute("roleId",roles.get(0).getRoleId());
        else
            model.addAttribute("roleId","");
        model.addAttribute("roleName",roleName);
        return "userInsert";
    }
    //跳转至用户更新
    @RequestMapping(value = "/toAdminUpdatePage", method = RequestMethod.GET)
    public String toUpdatePage(@RequestParam(value = "roleName")String roleName,@RequestParam(value = "userId")String userId,
                               HttpSession session,Model model){
        //校验传来的用户和角色是否匹配
        User user = userService.getUserWithRoleById(userId);
        if(user.getRole().getName().equals(roleName) && !user.getRole().getName().equals("admin")){
            model.addAttribute("updateUser",user);
            model.addAttribute("roleName",roleName);
        }
        return "userUpdate";
    }
    //查询所有用户
    @RequestMapping("/selectAllUsers")
    public String getUsers(HttpSession session,Model model){
        //分页查询，引入pagehelper插件
        //在查询之前调用，引入页码和页面大小
        //PageHelper.startPage(pn,5);
        //startPage后紧跟的就是分页查询
        List<User> users = userService.getAllUsersWithRole();
        //使用pageinfo包装查询后的结果，封装了查询详细信息和页面信息，将pageInfo交给页面
        //PageInfo pageInfo = new PageInfo(users,5);//可传入连续显示的页数
        //model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("users",users);
        return "admin";
    }


    //返回结果为json的查询
    @RequestMapping("/selectAllUsersWithJson")
    @ResponseBody
    public Msg getUsersWithJson(HttpSession session){

        List<User> users = userService.getAllUsersWithRole();
        return Msg.success("查询成功！").add("users",users);
    }


    //按条件查询用户
    @RequestMapping(value = "/selectUsers",method = RequestMethod.GET)
    public String getUsersWithRoleByRoleName(@RequestParam(value = "roleName",defaultValue = "")String roleName,
                                            HttpSession session,Model model){
        User curUser = (User)session.getAttribute("user");
        //非管理员不能查找管理员
        if(roleName.equals("admin")) roleName="";
        List<User> users = userService.getUsersWithRoleByExample(roleName,"","","","");
        model.addAttribute("users",users);
        model.addAttribute("searchRoleName",roleName);

        return roleName+"Mangement";
    }

    //查询的条件可在前端设置全局变量
    @RequestMapping(value = "/selectUsersWithJson",method = RequestMethod.GET)
    @ResponseBody
    public Msg getUsersWithRoleByExampleWithJson(@RequestParam(value = "roleName",defaultValue = "")String roleName,
                                            @RequestParam(value = "userName",defaultValue = "")String userName,
                                            @RequestParam(value = "gender",defaultValue = "")String gender,
                                            @RequestParam(value = "department",defaultValue = "")String department,
                                            @RequestParam(value = "class",defaultValue = "")String classes,
                                                 HttpSession session){

        //PageHelper.startPage(pn,5);
        List<User> users = userService.getUsersWithRoleByExample(roleName,userName,gender,department,classes);
        //PageInfo pageInfo = new PageInfo(users,5);//可传入连续显示的页数

        return Msg.success("查询成功！").add("users",users);
    }


    //通过输入添加用户
    @RequestMapping(value = "/addUsers",method = RequestMethod.POST)
    public String addUserByInput(User user,HttpSession session,Model model){
        userService.addUserByInput(user);
        model.addAttribute("addResult","complete");
        return "admin";
    }

    @RequestMapping(value = "/addUsersWithJson",method = RequestMethod.POST)
    @ResponseBody
    public Msg addUserByInputWithJson(HttpSession session,@Valid User user,BindingResult result){
        if(userService.getUserWithRoleById(user.getUserId())!=null){
            return Msg.fail("用户id重复！");
        }
        //数据后端校验
        if(result.hasErrors()){
            Map<String,Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for(FieldError fieldError:errors){
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail("处理失败！").add("errorFields",map);
        }

        userService.addUserByInput(user);
        return Msg.success("处理成功！");
    }


    //通过文件添加用户
    @RequestMapping(value = "/addUsersWithFile", method =RequestMethod.POST)
    @ResponseBody
    public Msg addUserByFile(@RequestParam(value="filename",required = false) MultipartFile file, HttpSession session,Model model){
        if(file==null) return Msg.fail("请选择文件！");
        //获取文件名
        String name = file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0) return Msg.fail("文件为空或不存在！");
        //批量导入。参数：文件名，文件。
        userService.addUserByFile(name, file);

        return Msg.success("导入成功！");
    }



    //更新用户
    @RequestMapping(value = "/updateUsers/{userId}",method = RequestMethod.PUT)
    public String updateUser(User user,HttpSession session,Model model){

        //数据后端校验
        userService.updateUser(user);
        model.addAttribute("updateResult","complete");
        return "admin";
    }

    @RequestMapping(value = "/updateUsersWithJson/{userId}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateUserWithJson(HttpSession session, @Valid User user, BindingResult result){

        //数据后端校验
        if(result.hasErrors()){
            Map<String,Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for(FieldError fieldError:errors){
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail("更新失败！").add("errorFields",map);
        }
        userService.updateUser(user);
        return Msg.success("更新成功！");
    }

    @RequestMapping(value = "/updatePasswordWithJson",method = RequestMethod.POST)
    @ResponseBody
    public Msg updatePasswordWithJson(HttpSession session,
                                      @RequestParam(value = "userId",defaultValue = "")String userId,
                                      @RequestParam(value = "old_password",defaultValue = "")String oldPassword,
                                      @RequestParam(value = "password",defaultValue = "")String password){
        User user = userService.getUserWithRoleById(userId);
        if(!user.getPassword().equals(oldPassword)){
            return Msg.fail("当前密码错误！");
        }
        user.setPassword(password);
        userService.updateUser(user);
        return Msg.success("密码修改成功！");
    }

    //单个/批量删除用户，批量需传入以“-”分隔的用户id
    @RequestMapping(value = "/deleteUsers/{ids}",method = RequestMethod.DELETE)
    public String deleteUsers(@PathVariable("ids")String ids,HttpSession session,Model model){
        if(ids.contains("-")){
            List<String> del_ids = new ArrayList<>();
            String[] str_ids= ids.split("-");
            for(String string:str_ids){
                del_ids.add(string);
            }
            userService.deleteUsers(del_ids);
        }
        else{
            userService.deleteUser(ids);
        }
        model.addAttribute("deleteResult","complete");
        return "admin";
    }

    @RequestMapping(value = "/deleteUsersWithJson/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteUsersWithJson(@PathVariable("ids")String ids,HttpSession session){
        if(ids.contains("-")){
            List<String> del_ids = new ArrayList<>();
            String[] str_ids= ids.split("-");
            for(String string:str_ids){
                del_ids.add(string);
            }
            userService.deleteUsers(del_ids);
        }
        else{
            userService.deleteUser(ids);
        }
        return Msg.success("删除完成！");
    }
}


