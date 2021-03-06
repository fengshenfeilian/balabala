package com.managementSystem.service;

import com.managementSystem.dao.*;
import com.managementSystem.pojo.*;
import com.managementSystem.util.ReadExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service("teacherService")
public class TeacherService {

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

    public void deleteAssignmentById(String assignmentId){
        assignmentMapper.deleteByPrimaryKey(assignmentId);
        //删除作业要求和提交的作业
        Group_AssignmentExample group_assignmentExample = new Group_AssignmentExample();
        Group_AssignmentExample.Criteria criteria = group_assignmentExample.createCriteria();
        criteria.andAssignmentIdEqualTo(assignmentId);
        group_assignmentMapper.deleteByExample(group_assignmentExample);
    }
    public List<Course> getAllCourses(String teacherId)
    {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacherIdEqualTo(teacherId);
        List<Course> courses = courseMapper.selectByExample(courseExample);
        return courses;
    }

    public void createNewCourse(Course course)
    {
        //由于课程id自增，插入后才能知道课程id
        courseMapper.insert(course);
        String groupPrefix = Integer.toString(course.getCourseId())+"-"+course.getGroupPrefix();
        course.setGroupPrefix(groupPrefix);
        courseMapper.updateByPrimaryKeySelective(course);
    }

    public void addUserByFile(String name, MultipartFile file, Integer courseId) {
        ReadExcel readExcel = new ReadExcel();
        List<Student_Course> student_courses = readExcel.getStudentId(name, file);
        for (Student_Course student_course : student_courses) {
            Student_CourseKey key = new Student_CourseKey();
            key.setCourseId(courseId);
            key.setStudentId(student_course.getStudentId());

            student_course.setCourseId(courseId);
            student_course.setDailyGrade(0);
            student_course.setAssignmentGrade(0);
            if(student_courseMapper.selectByPrimaryKey(key)==null)
                //System.out.println("test");
                student_courseMapper.insertSelective(student_course);
        }
    }

    public Integer getCourseId(String courseName, String teacherId)
    {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacherIdEqualTo(teacherId);
        criteria.andCourseNameEqualTo(courseName);
        List<Course> course = courseMapper.selectByExample(courseExample);
        return course.get(0).getCourseId();
    }

    public void addAssignment(Assignment assignment)
    {
        assignmentMapper.insertSelective(assignment);
    }

    public List<Assignment> getAssignments(Integer courseId)
    {
        AssignmentExample assignmentExample = new AssignmentExample();
        AssignmentExample.Criteria criteria = assignmentExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        List<Assignment> assignments = assignmentMapper.selectByExample(assignmentExample);
        return assignments;
    }

    public long getAssignmentNumber(Integer courseId) {
        AssignmentExample assignmentExample = new AssignmentExample();
        AssignmentExample.Criteria criteria = assignmentExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        long num = assignmentMapper.countByExample(assignmentExample);
        String assignId = courseId.toString()+ "-" + String.valueOf(num);
        while(assignmentMapper.selectByPrimaryKey(assignId)!=null){
            num++;
          assignId = courseId.toString()+ "-" + String.valueOf(num);
        }
        return num;
    }

    public List<Group_Assignment> getSubmitedAssignments(String assignmentId) {
        Group_AssignmentExample group_assignmentExample = new Group_AssignmentExample();
        Group_AssignmentExample.Criteria criteria = group_assignmentExample.createCriteria();
        criteria.andAssignmentIdEqualTo(assignmentId);
        return group_assignmentMapper.selectByExample(group_assignmentExample);
    }

    public List<Student_Course> getAllStudents(Integer courseId) {
        Student_CourseExample student_courseExample = new Student_CourseExample();
        Student_CourseExample.Criteria criteria = student_courseExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        List<Student_Course> ans = student_courseMapper.selectByExample(student_courseExample);
        return ans;
    }

    public String getGroupID(Integer courseId, String studentId) {
        String groupId = groupMapper.selectByUseridCourseid(courseId, studentId);
        return groupId;
    }

    public List<Group_Assignment> getGroupAssignemnt(String groupId) {
        Group_AssignmentExample group_assignmentExample = new Group_AssignmentExample();
        Group_AssignmentExample.Criteria criteria = group_assignmentExample.createCriteria();
        criteria.andGroupIdEqualTo(groupId);
        return group_assignmentMapper.selectByExample(group_assignmentExample);
    }

    public Integer getAssignmentPercent(String assignmentId) {
        Integer percent = assignmentMapper.getPercent(assignmentId);
        return percent;
    }

    public void updateGrade(Student_Course student_course) {
        student_courseMapper.updateByPrimaryKeySelective(student_course);
    }

    public Integer getGroupGrade(Integer courseId, String studentId) {
        Integer groupGrade = groupMapper.selectGrade(courseId, studentId);
        return groupGrade;
    }

    public List<Student_Course> getAllStudentsInfo(Integer courseId) {
        Student_CourseExample student_courseExample = new Student_CourseExample();
        Student_CourseExample.Criteria criteria = student_courseExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        List<Student_Course> student_courses = student_courseMapper.selectByExample(student_courseExample);
        for (Student_Course student_course : student_courses)
        {
            User user = userMapper.selectByPrimaryKey(student_course.getStudentId());
//            student_course.setClassName(user.getClasses());
//            student_course.setName(user.getUserName());
        }
        return student_courses;
    }

    public List<Group_Assignment> getAssignmentsByCondition(String title, String groupName) {
        String groupId = groupMapper.selectId(groupName);
        AssignmentExample assignmentExample = new AssignmentExample();
        AssignmentExample.Criteria criteria = assignmentExample.createCriteria();
        criteria.andTitleEqualTo(title);
        List<Assignment> assignments = assignmentMapper.selectByExample(assignmentExample);
        String assignmentId = assignments.get(0).getAssignmentId();
        Group_AssignmentExample group_assignmentExample = new Group_AssignmentExample();
        Group_AssignmentExample.Criteria criteriaGA = group_assignmentExample.createCriteria();
        criteriaGA.andGroupIdEqualTo(groupId);
        criteriaGA.andAssignmentIdEqualTo(assignmentId);
        return group_assignmentMapper.selectByExample(group_assignmentExample);
    }

    public Course getCurrentCourse(int id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    public Assignment getCurrentAssignment(String assignmentId) {
        return assignmentMapper.selectByPrimaryKey(assignmentId);
    }

    public Group getGroup(String groupId) {
        return groupMapper.selectByPrimaryKey(groupId);
    }

    public User getStudent(String groupId) {
        Group group = groupMapper.selectByPrimaryKey(groupId);
        User user = userMapper.selectByPrimaryKey(group.getLeaderId());
        return user;
    }

    public Group_Assignment getCurrentGroupAssignemnt(String groupId, String assignmentId) {
        Group_AssignmentKey group_assignmentKey = new Group_AssignmentKey();
        group_assignmentKey.setAssignmentId(assignmentId);
        group_assignmentKey.setGroupId(groupId);
        return group_assignmentMapper.selectByPrimaryKey(group_assignmentKey);
    }

    public List<Group_Student> getGroupStudents(String groupId) {
        Group_StudentExample group_studentExample = new Group_StudentExample();
        Group_StudentExample.Criteria criteria = group_studentExample.createCriteria();
        criteria.andGroupIdEqualTo(groupId);
        return group_studentMapper.selectByExample(group_studentExample);
    }

    public User getStudentsInGroup(String studentId) {
        return userMapper.selectByPrimaryKey(studentId);
    }

    public void updateGroupGrade(Group_Assignment group_assignment) {
        group_assignmentMapper.updateByPrimaryKey(group_assignment);
    }

    public void addDailyScore(String name, MultipartFile file, Integer courseId) {
        ReadExcel readExcel = new ReadExcel();
        List<Student_Course> users = readExcel.getDailyScore(name, file);
        for(Student_Course student_course : users)
        {
            student_course.setCourseId(courseId);
            student_courseMapper.updateByPrimaryKeySelective(student_course);
        }
    }

    public List<User> getAllUsers(List<Student_Course> student_courses) {
        List<User> users = new ArrayList<>();
        for (Student_Course student_course : student_courses)
        {
            User user = userMapper.selectByPrimaryKey(student_course.getStudentId());
            if(user!=null)
            users.add(user);
        }
        return users;
    }

    public int getCount(String userId) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacherIdEqualTo(userId);
        return (int)courseMapper.countByExample(courseExample);
    }

    public boolean findCourse(Course course) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();
        criteria.andTeacherIdEqualTo(course.getTeacherId());
        criteria.andCreateTimeEqualTo(course.getCreateTime());
        criteria.andCourseNameEqualTo(course.getCourseName());
        List<Course> courses = courseMapper.selectByExample(courseExample);
        if(courses.size() == 0)
        {
            return false;
        }
        return true;
    }

    public void setCourseEnd(Course course) {
        courseMapper.updateByPrimaryKey(course);
    }

    public int getAssignmentCount(Integer courseId) {
        AssignmentExample assignmentExample = new AssignmentExample();
        AssignmentExample.Criteria criteria = assignmentExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        return (int)assignmentMapper.countByExample(assignmentExample);
    }

    public void updatePercent(Assignment assignment) {
        assignmentMapper.updateByPrimaryKey(assignment);
    }

    public void deleteStudent(String studentId,Integer courseId){
        Student_CourseKey key = new Student_CourseKey();
        key.setStudentId(studentId);key.setCourseId(courseId);
        student_courseMapper.deleteByPrimaryKey(key);
    }
}
