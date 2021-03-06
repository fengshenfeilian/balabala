package com.managementSystem.controller;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/user")
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
            ,@RequestParam(value = "password")String password,Model model,HttpServletRequest request){
        //加入session相关的操作
        //前端传来的密码应该是md5加密后的32位密码
        System.out.println(userId);
        System.out.println(password);
        User user = userService.checkLogin(userId,password);
        if(user != null){
            request.getSession().setAttribute("currentUser",user);
            model.addAttribute("user",user);
            //根据不同角色传入不同属性
            if(user.getRoleId().equals("1")){
                return "redirect:/user/AdminIndex";
            }
            else if(user.getRoleId().equals("2"))
            {
            /*
             model.addAttribute("message", "登陆成功");
             List<Course> courses = teacherService.getAllCourses(userId);
             model.addAttribute("courses", courses);
            */
                return "redirect:/teacher/index";
            }
            //学生登录
            else if(user.getRoleId().equals("3")){
                if(user.getPwdDefault()==1)
                    return  "/student/userConfig";
                return "redirect:/student/home";
            }
            else {
                model.addAttribute("message","角色不存在");
                return "redirect:/login.jsp";
            }
           /* if(user.getRole().getName().equals("admin")){

            }
            else if(user.getRole().getName().equals("teacher")){

            }
            else if(user.getRole().getName().equals("student")){

            }
            else{
                model.addAttribute("message","未知用户");
                return "loginError";
            }*/
        }

        model.addAttribute("message","用户名或密码错误");

        return "redirect:/login.jsp";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String UserLogout(HttpSession session, Model model){
        session.removeAttribute("currentUser");
        session.invalidate();
        model.addAttribute("message","注销成功");
        //此处返回登录页
        return "redirect:/login.jsp";
    }

    @RequestMapping(value = "/AdminIndex")
    public String toIndexPage(HttpSession session,Model model){
        //User curUser = (User)session.getAttribute("user");
        return "admin/adminIndex";
    }
    //跳转至账户信息页面
    @RequestMapping(value = "/toConfigPage")
    public String toConfigPage(HttpSession session,Model model){
        User user = (User)session.getAttribute("currentUser");
        if(user.getRoleId().equals("1")){
            return "admin/userConfig";
        }
        else if(user.getRoleId().equals("2")){
            return "/teacher/userConfig";
        }
        else if(user.getRoleId().equals("3")){
            return "/student/userConfig";
        }
        return "admin/userConfig";
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
        return "admin/userInsert";
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
        return "admin/userUpdate";
    }



    //返回结果为json的查询
    @RequestMapping("/selectAllUsersWithJson")
    @ResponseBody
    public Msg getUsersWithJson(HttpSession session){

        List<User> users = userService.getAllUsersWithRole();
        return Msg.success("查询成功！").add("users",users);
    }


    //按条件查询用户
    //加入鉴权
    @RequestMapping(value = "/selectUsers",method = RequestMethod.GET)
    public String getUsersWithRoleByRoleName(@RequestParam(value = "roleName",defaultValue = "")String roleName,
                                            HttpSession session,Model model){
        User curUser = (User)session.getAttribute("currentUser");
        //用户管理权限
       if(!userService.Authenticate(curUser.getRoleId(),"UC42")){
            return null;
        }
        //非管理员不能查找管理员
        List<User> users = userService.getUsersWithRoleByExample(roleName,"","","","");
        model.addAttribute("users",users);
        model.addAttribute("searchRoleName",roleName);

        if(roleName.equals("student"))
            return "admin/studentMangement";
        else if(roleName.equals("teacher"))
            return "admin/teacherMangement";
        return null;
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




    //加入鉴权
    @RequestMapping(value = "/addUsersWithJson",method = RequestMethod.POST)
    @ResponseBody
    public Msg addUserByInputWithJson(HttpSession session,@Valid User user,BindingResult result){
        User curUser = (User)session.getAttribute("currentUser");
        //用户管理权限
        if(!userService.Authenticate(curUser.getRoleId(),"UC42")){
            return Msg.fail("用户权限不足！");
        }
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
    //加入鉴权
    @RequestMapping(value = "/addUsersWithFile", method =RequestMethod.POST)
    @ResponseBody
    public Msg addUserByFile(@RequestParam(value="filename",required = false) MultipartFile file, HttpSession session,Model model){
        User curUser = (User)session.getAttribute("currentUser");
        //导入用户权限
        if(!userService.Authenticate(curUser.getRoleId(),"UC41")){
            return Msg.fail("用户权限不足！");
        }

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


    //用户修改个人信息
    //加入鉴权
    @RequestMapping(value = "/updateUsersWithJson/{userId}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateUserWithJson(HttpSession session, @Valid User user, BindingResult result){

        User curUser = (User)session.getAttribute("currentUser");
        //更新个人信息权限
        if(!userService.Authenticate(curUser.getRoleId(),"UC1")){
            return Msg.fail("用户权限不足！");
        }
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

    //管理员修改用户信息
    //加入鉴权
    @RequestMapping(value = "/adminUpdateUsersWithJson/{userId}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg adminUpdateUserWithJson(HttpSession session, @Valid User user, BindingResult result){

        User curUser = (User)session.getAttribute("currentUser");
        //用户管理权限
        if(!userService.Authenticate(curUser.getRoleId(),"UC42")){
            return Msg.fail("用户权限不足！");
        }
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


    //加入鉴权
    @RequestMapping(value = "/updatePasswordWithJson",method = RequestMethod.POST)
    @ResponseBody
    public Msg updatePasswordWithJson(HttpSession session,
                                      @RequestParam(value = "userId",defaultValue = "")String userId,
                                      @RequestParam(value = "old_password",defaultValue = "")String oldPassword,
                                      @RequestParam(value = "password",defaultValue = "")String password){

        User curUser = (User)session.getAttribute("currentUser");
        //更新个人信息权限
        if(!userService.Authenticate(curUser.getRoleId(),"UC1")){
            return Msg.fail("用户权限不足！");
        }
        User user = userService.getUserWithRoleById(userId);
        System.out.println(oldPassword);
        System.out.println(user.getPassword());
        //判断旧密码是否输入正确
        if(!user.getPassword().equals(oldPassword)){
            return Msg.fail("当前密码错误！");
        }
        //判断密码是否默认
        String default_password = MD5Utils.getPwd(user.getUserId());
        System.out.println(default_password);
        if(default_password.equals(password)){
            user.setPwdDefault(1);
        }
        else{
            user.setPwdDefault(0);
        }
        user.setPassword(password);
        userService.updateUser(user);
        return Msg.success("密码修改成功！");
    }

    //单个/批量删除用户，批量需传入以“-”分隔的用户id
   //加入鉴权
    @RequestMapping(value = "/deleteUsersWithJson/{ids}",method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteUsersWithJson(@PathVariable("ids")String ids,HttpSession session){
        User curUser = (User)session.getAttribute("currentUser");
        //用户管理权限
        if(!userService.Authenticate(curUser.getRoleId(),"UC42")){
            return Msg.fail("用户权限不足！");
        }
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


