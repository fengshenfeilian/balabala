package com.managementSystem.controller;


import com.managementSystem.pojo.Group_Assignment;
import com.managementSystem.service.StudentService;
import com.managementSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
@SessionAttributes("user")
public class StudentController {
    @Autowired
    StudentService studentService;

    //进入首页
    @RequestMapping(value = "/home")
    public String gotoIndex(){
        return "student/home";
    }
    //进入课程页
    @RequestMapping(value = "/course")
    public String gotoCourse(){
        return "student/course";
    }
    //进入作业信息页
    @RequestMapping(value = "/assignment")
    public String gotoAssignment(){
        return "student/assignment";
    }
    //进入作业上传页
    @RequestMapping(value = "/uploadAssignment")
    public String gotoUploadAssignment(){
        return "student/uploadAssignment";
    }
    //进入小组信息页
    @RequestMapping(value = "/group")
    public String gotoGroup(){
        return "student/group";
    }
    //进入添加小组页
    @RequestMapping(value = "/addGroup")
    public String gotoAddGroup(){
        return "student/addGroup";
    }


    //获取小组提交的作业
    public String getGroupAssignment(){
        List<Group_Assignment> groupAssignment = studentService.getAll();
        return "list";
    }

}
