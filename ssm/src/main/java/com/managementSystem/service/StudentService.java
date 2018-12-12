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
    public List<Group_Student> getGroupStudent(String studentId) {
        Group_StudentExample gpExample = new Group_StudentExample();
        Group_StudentExample.Criteria criteria = gpExample.createCriteria();
        criteria.andStudentIdEqualTo(studentId);
        return group_studentMapper.selectByExample(gpExample);
    }

    public List<Group_Assignment> getGroupAssignmentByGroupId(Integer groupId) {
        Group_AssignmentExample gaExample = new Group_AssignmentExample();
        Group_AssignmentExample.Criteria criteria = gaExample.createCriteria();
        criteria.andGroupIdEqualTo(groupId);
        List<Group_Assignment> ga = group_assignmentMapper.selectByExample(gaExample);
        return ga;
    }

    public List<String> getCourseNameByGroupStudentList(List<Group_Student> gs) {
        List<String> courseName = new ArrayList<>();
        for (Group_Student groupStudent : gs) {
            Group group = groupMapper.selectByPrimaryKey(groupStudent.getGroupId());
            String name = groupMapper.selectCourseNameByCourseId(group.getCourseId());
            courseName.add(name);
        }
        return courseName;
    }

    public Integer getGroupIdByStudentId(String studentId)
    {
        return group_studentMapper.selectGroupIdByStudentId(studentId);
    }

    public Group getGroupByStudentId(int groupId)
    {
        return groupMapper.selectByPrimaryKey(groupId);
    }

    public boolean existAssignment(String assignmentId)
    {
        return assignmentMapper.existAssignment(assignmentId);
    }

    public boolean existGroupAssignment(String assignmentId, Integer groupId)
    {
        return group_assignmentMapper.existGroupAssignment(assignmentId,groupId);
    }

    public void deleteGroupAssignment(String assignmentId,Integer groupId)
    {
        Group_AssignmentKey gak = new Group_AssignmentKey();
        gak.setAssignmentId(assignmentId);
        gak.setGroupId(groupId);
        group_assignmentMapper.deleteByPrimaryKey(gak);
    }

    //查询当前学生所选课程
    public List<Student_Course> getCourseListByUserId(String userId)
    {
        Student_CourseExample scExample = new Student_CourseExample();
        Student_CourseExample.Criteria criteria = scExample.createCriteria();
        criteria.andStudentIdEqualTo(userId);
        return student_courseMapper.selectByExample(scExample);
    }

    //上传作业 ：插入group_assignment表
    public void insertGroupAssignment(Group_Assignment ga)
    {
        group_assignmentMapper.insert(ga);
    }

    public User getUserById(String userId)
    {
         return userMapper.selectByPrimaryKey(userId);
    }

    public List<User> getAllStudent()
    {
        return userMapper.selectByExampleWithRole(null);
    }

    public List<User> getGroupByStudentList(List<User> userList)
    {
        List<User> list = new ArrayList<>();
        for (User user : userList) {
           // Group group = groupMapper.selectByPrimaryKey(groupStudent.getGroupId());
            //String name = groupMapper.selectCourseNameByCourseId(group.getCourseId());
            //courseName.add(name);
            //如果在group_student表中找到user，则跳过，否则把它加入list
            if(group_studentMapper.existStudent(user.getUserId())){
                continue;
            }
            //判断该用户是否是学生
            else if(user.getRoleId().equals("3")){
                list.add(user);
            }
        }
        return list;
    }

    public int getCountGroupMember(int groupId){
        //查找group_student表中groupId的数量
        return group_studentMapper.getStudentCountByGroupId(groupId);
    }
    public void insertGroupStudent(int groupId,String studentId)
    {
        Group_Student gs = new Group_Student();
        gs.setGroupId(groupId);
        gs.setStudentId(studentId);
        group_studentMapper.insert(gs);
    }
}

