package com.how2java.controller;

import com.how2java.pojo.User;
import com.how2java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import java.util.List;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(String name, String password,  HttpSession session)
    {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.login(name, password);
        if(user != null)
        {
            session.setAttribute("user", user);
            return "admin";
        }
        else
        {
            modelAndView.addObject("message", "用户名或密码错误，请重新输入");
            return "index";
        }
    }

    @RequestMapping("/createStudent")
    public String createStudents(List<User> users)
    {
        userService.createStudents(users);
        return "admin";
    }

    @RequestMapping("/createTeacher")
    public String createTeachers(List<User> users)
    {
        userService.createTeachers(users);
        return "admin";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user)
    {
        userService.updateUserInfo(user);
        return "admin";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(String id)
    {
        userService.deleteUser(id);
        return "admin";
    }

}
