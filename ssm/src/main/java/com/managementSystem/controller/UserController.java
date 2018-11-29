package com.managementSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.managementSystem.pojo.Msg;
import com.managementSystem.pojo.User;
import com.managementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/user")
@SessionAttributes("user")//将名为user的属性加入session中，这样保证了session中存在User对象
public class UserController {

    @Autowired
    UserService userService;

    //用户控制器，实现了返回json和返回jsp的两种方法
    //用户名单导入
    @RequestMapping(value = "/importUserList", method = RequestMethod.GET)
   public String importUser(){
        return "fileUpload";
    }

    //用户登陆，输入用户id和密码
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String UserLogin(@RequestParam(value = "userId")String userId
            ,@RequestParam(value = "password")String password,Model model){
        //加入session相关的操作
        User user = userService.checkLogin(userId,password);
        if(user != null && user.getRoleId().equals("1")){
            model.addAttribute("message","登陆成功");
            model.addAttribute("user",user);
            List<User> users = userService.getUsers("3");
            model.addAttribute("users", users);
            return "index";
        }

        model.addAttribute("message","用户名或密码错误");
        //此处返回页面待定
        return "loginError";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String UserLogout(HttpSession session,Model model){
        session.invalidate();
        model.addAttribute("message","注销成功");
        //此处返回页面待定
        return "admin";
    }


    //查询所有用户
    @RequestMapping("/selectUsers")
    public String getUsers(@RequestParam(value = "pn",defaultValue = "1")Integer pn,Model model){
        //分页查询，引入pagehelper插件
        //在查询之前调用，引入页码和页面大小
        PageHelper.startPage(pn,5);
        //startPage后紧跟的就是分页查询
        List<User> users = userService.getAllUsersWithRole();
        //使用pageinfo包装查询后的结果，封装了查询详细信息和页面信息，将pageInfo交给页面
        PageInfo pageInfo = new PageInfo(users,5);//可传入连续显示的页数
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("users", users);
        return "admin";
    }


    //返回结果为json的查询
    @RequestMapping("/selectUsersWithJson")
    @ResponseBody
    public Msg getUsersWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        //分页查询，引入pagehelper插件
        //在查询之前调用，引入页码和页面大小
        PageHelper.startPage(pn,5);
        //startPage后紧跟的就是分页查询
        List<User> users = userService.getAllUsersWithRole();
        //使用pageinfo包装查询后的结果，封装了查询详细信息和页面信息，将pageInfo交给页面
        PageInfo pageInfo = new PageInfo(users,5);//可传入连续显示的页数
        return Msg.success("查询成功！").add("pageInfo",pageInfo);
    }


    //按条件查询，待完成
    @RequestMapping(value = "/selectUsers/{example}",method = RequestMethod.GET)
    public String getUsersWithRoleByExample(){

        userService.getUserWithRoleByExample();
        return "admin";
    }


    //添加用户
    @RequestMapping(value = "/addUsers",method = RequestMethod.POST)
    public String addUserByInput(User user,Model model){
        userService.addUserByInput(user);
        model.addAttribute("addResult","complete");
        return "admin";
    }

    @RequestMapping(value = "/addUsersWithJson",method = RequestMethod.POST)
    @ResponseBody
    public Msg addUserByInputWithJson(User user){

        //某些数据需要后端校验
        userService.addUserByInput(user);
        return Msg.success("新建成功！");
    }


    //通过文件导入，待完成
    @RequestMapping(value = "/addUsersWithFile", method =RequestMethod.POST)
    public String addUserByFile(@RequestParam(value="filename") MultipartFile file, Model model){
        if(file==null) return null;
        //获取文件名
        String name = file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0) return null;
        //批量导入。参数：文件名，文件。
        userService.addUserByFile(name, file);
        List<User> users = userService.getUsers("3");
        model.addAttribute("users", users);
        return "index";
    }



    //更新用户
    @RequestMapping(value = "/updateUsers/{userId}",method = RequestMethod.PUT)
    public String updateUser(User user,Model model){

        //数据可能需要后端校验
        userService.updateUser(user);
        model.addAttribute("updateResult","complete");
        return "admin";
    }

    @RequestMapping(value = "/updateUsersWithJson/{userId}",method = RequestMethod.PUT)
    @ResponseBody
    public Msg updateUserWithJson(User user){

        //数据可能需要后端校验
        userService.updateUser(user);
        return Msg.success("更新成功！");
    }

    //单个/批量删除用户，批量需传入以“-”分隔的用户id
    @RequestMapping(value = "/deleteUsers/{ids}",method = RequestMethod.DELETE)
    public String deleteUsers(@PathVariable("ids")String ids,Model model){
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
    public Msg deleteUsersWithJson(@PathVariable("ids")String ids){
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


