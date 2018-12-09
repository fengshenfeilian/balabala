package com.managementSystem.service;

import com.managementSystem.dao.*;
import com.managementSystem.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentService {
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    Student_CourseMapper student_courseMapper;

    @Autowired
    AssignmentMapper assignmentMapper;

    @Autowired
    Group_AssignmentMapper group_assignmentMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    GroupMapper groupMapper;

    @Autowired
    Group_StudentMapper group_studentMapper;

    //获取当前学生的课程列表


}
