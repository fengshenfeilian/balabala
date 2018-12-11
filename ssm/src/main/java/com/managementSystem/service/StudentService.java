package com.managementSystem.service;

import com.managementSystem.dao.*;
import com.managementSystem.pojo.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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


    //从Group_Student表中获取当前用户的所有小组
    public List<Group_Student> getGroupStudent(String studentId){
        Group_StudentExample gpExample = new Group_StudentExample();
        Group_StudentExample.Criteria criteria = gpExample.createCriteria();
        criteria.andStudentIdEqualTo(studentId);
        return group_studentMapper.selectByExample(gpExample);
    }

    public List<Group_Assignment> getGroupAssignmentByGroupId(Integer groupId)
    {
        Group_AssignmentExample gaExample = new Group_AssignmentExample();
        Group_AssignmentExample.Criteria criteria = gaExample.createCriteria();
        criteria.andGroupIdEqualTo(groupId);
        List<Group_Assignment> ga = group_assignmentMapper.selectByExample(gaExample);
        return ga;
    }

    public List<String> getCourseNameByGroupStudentList(List<Group_Student> gs)
    {
        List<String> courseName = new ArrayList<>();
        for(Group_Student groupStudent : gs)
        {
            Group group = groupMapper.selectByPrimaryKey(groupStudent.getGroupId());
            String name = groupMapper.selectCourseNameByCourseId(group.getCourseId());
            courseName.add(name);
        }
        return courseName;
    }
/*
    public List<User> getAllUsers(List<Student_Course> student_courses) {
        List<User> users = new ArrayList<>();
        for (Student_Course student_course : student_courses)
        {
            User user = userMapper.selectByPrimaryKey(student_course.getStudentId());
            users.add(user);
        }
        return users;
    }*/
}

/*
    public List<Assignment> getAssignments(Integer courseId)
    {
        AssignmentExample assignmentExample = new AssignmentExample();
        AssignmentExample.Criteria criteria = assignmentExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        List<Assignment> assignments = assignmentMapper.selectByExample(assignmentExample);
        return assignments;
    }*/

