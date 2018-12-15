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

    public List<Group_Assignment> getGroupAssignmentByGroupId(String groupId) {
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

    public List<Course> getCourseByGroupStudentList(List<Group_Student> gs) {
        List<Course> course = new ArrayList<>();
        for (Group_Student groupStudent : gs) {
            Group group = groupMapper.selectByPrimaryKey(groupStudent.getGroupId());
            Course c = courseMapper.selectByPrimaryKey(group.getCourseId());
            course.add(c);
        }
        return course;
    }
    //groupId
    public String getGroupIdByStudentId(String studentId)
    {
        return group_studentMapper.selectGroupIdByStudentId(studentId);
    }





    public boolean existAssignment(String assignmentId)
    {
        return assignmentMapper.existAssignment(assignmentId);
    }

    public boolean existGroupAssignment(String assignmentId, String groupId)
    {
        return group_assignmentMapper.existGroupAssignment(assignmentId,groupId);
    }

    public void deleteGroupAssignment(String assignmentId,String  groupId)
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

    //判断学生是否选了该课
    public boolean courseNotSelected(String userId,Integer courseId){
        Student_CourseExample scExample = new Student_CourseExample();
        Student_CourseExample.Criteria criteria = scExample.createCriteria();
        criteria.andStudentIdEqualTo(userId);
        criteria.andCourseIdEqualTo(courseId);
        System.out.println(userId);
        System.out.println(courseId);
        List<Student_Course> sc = student_courseMapper.selectByExample(scExample);
        if(sc==null || sc.size()==0)return true;
        return false;
    }

    //获取作业要求
    public List<Assignment> getAssignments(Integer courseId)
    {
        AssignmentExample assignmentExample = new AssignmentExample();
        AssignmentExample.Criteria criteria = assignmentExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        List<Assignment> assignments = assignmentMapper.selectByExample(assignmentExample);
        return assignments;
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


    public int getCountGroupMember(String groupId){
        //查找group_student表中groupId的数量
        return group_studentMapper.getStudentCountByGroupId(groupId);
    }

    //添加一个小组成员
    public void insertGroupMember(String groupId,String studentId)
    {
        //Group_Student表更新
        Group_Student gs = new Group_Student();
        gs.setGroupId(groupId);
        gs.setStudentId(studentId);
        group_studentMapper.insert(gs);
        //Group_Course表更新(小组成员数量 + 1)
        Group group = groupMapper.selectByPrimaryKey(groupId);
        group.setGroupMemberNum(group.getGroupMemberNum() + 1);
        groupMapper.updateByPrimaryKey(group);
    }

    //删除一个小组成员
    public void deleteGroupMember(String groupId,String studentId)
    {
        //Group_Student表更新
        Group_Student gs = new Group_Student();
        gs.setGroupId(groupId);
        gs.setStudentId(studentId);
        group_studentMapper.deleteByPrimaryKey(gs);
        //Group_Course表更新(小组成员数量 - 1)
        Group group = groupMapper.selectByPrimaryKey(groupId);
        group.setGroupMemberNum(group.getGroupMemberNum() - 1);
        groupMapper.updateByPrimaryKey(group);
    }

    //在G_S表查找该学生的所有小组
    public List<Group_Student> getGroupListByStudentId(String studentId)
    {
        Group_StudentExample group_studentExample = new Group_StudentExample();
        Group_StudentExample.Criteria criteria = group_studentExample.createCriteria();
        criteria.andStudentIdEqualTo(studentId);
        return group_studentMapper.selectByExample(group_studentExample);
    }
    //G_S表 -> Group表的映射
    public List<Group> getGroupListByGSList(List<Group_Student> gsList)
    {
        List<Group> list = new ArrayList<>();
        for (Group_Student gs : gsList) {
            Group group = groupMapper.selectByPrimaryKey(gs.getGroupId());
            list.add(group);
        }
        return list;
    }

    //获取该课程的所有小组
    public List<Group> getGroupListByCourseId(int  courseId){
        List<Group> list = new ArrayList<>();
        GroupExample groupExample = new GroupExample();
        GroupExample.Criteria criteria = groupExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        return groupMapper.selectByExample(groupExample);
    }

    //判断两个List是否有交集
    public Boolean groupNotNull(List<Group_Student> studentGroupList,List<Group> courseGroupList)
    {
        for(Group_Student gs : studentGroupList){
            String groupId = gs.getGroupId();
            for(Group courseGroup : courseGroupList){
                if(courseGroup.getGroupId().equals(groupId)){
                    return true;
                }
            }
        }
        return false;
    }

    /*
        创建小组：
        1.（根据courseGroup.count）获取小组号
        2. gourpMemberNum = 1
        3. leaderId = userId
    */
    public void insertGroup(int courseId, String groupName,String userId )
    {
        //获取该课程下小组个数
        GroupExample groupExample = new GroupExample();
        GroupExample.Criteria criteria = groupExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        long groupCount = groupMapper.countByExample(groupExample);
        int cnt = (int)groupCount;
        Integer groupCnt = cnt;
        //获取小组前缀
        Course course = courseMapper.selectByPrimaryKey(courseId);
        String prefix = course.getGroupPrefix();
        //生成小组号
        String groupId = prefix  + Integer.toString(groupCnt + 1);
        Integer groupMemberNum = 1;
        //创建新的小组对象
        Group newGroup = new Group();
        newGroup.setGroupId(groupId);
        newGroup.setCourseId(courseId);
        newGroup.setGroupName(groupName);
        newGroup.setGroupMemberNum(groupMemberNum);
        newGroup.setLeaderId(userId);
        //向数据表Group_Course插入小组
        groupMapper.insert(newGroup);
        //向数据表Group_Student插入小组_学生数据
        Group_Student newGS = new Group_Student();
        newGS.setStudentId(userId);
        newGS.setGroupId(groupId);
        group_studentMapper.insert(newGS);
    }

    //当前课程的所有学生
    public List<User> getAllCourseStudent(int courseId)
    {
        List<User> list = new ArrayList<>();
        Student_CourseExample scExample = new Student_CourseExample();
        Student_CourseExample.Criteria criteria = scExample.createCriteria();
        criteria.andCourseIdEqualTo(courseId);
        List<Student_Course> scList = student_courseMapper.selectByExample(scExample);
        for(Student_Course sc : scList)
        {
            User user = userMapper.selectByPrimaryKey(sc.getStudentId());
            list.add(user);
        }
        return list;
    }
    //获取当前课程已有小组的学生
    public List<User> getCourseStudentWithGroup(int courseId)
    {
        List<User> list = new ArrayList<>();
        //获取该课程的所有小组
        List<Group> groupList = getGroupListByCourseId(courseId);
        //遍历该课程下所有小组
        for(Group group : groupList)
        {
            Group_StudentExample gsExample = new Group_StudentExample();
            Group_StudentExample.Criteria criteria = gsExample.createCriteria();
            criteria.andGroupIdEqualTo(group.getGroupId());
            List<Group_Student> gsList = group_studentMapper.selectByExample(gsExample);
            //遍历该小组所有学生
            for( Group_Student gs : gsList )
            {
                User user = userMapper.selectByPrimaryKey(gs.getStudentId());
                list.add(user);
            }
        }
        return list;
    }

    //当前课程所有学生 - 当前课程已有小组的学生
    public List<User> userRemoveCurrentCourse(List<User> userList, List<User> courseStudentListWithGroup)
    {
        List<User> list = new ArrayList<>();
        for(User curStudent : userList)
        {
            Boolean available = true;
            for(User currentCourseUser : courseStudentListWithGroup)
            {
                if(currentCourseUser.getUserId().equals(curStudent.getUserId())){//当前课程已有小组的学生不可选
                    available = false;
                    break;
                }

            }
            if(!available)continue;
            list.add(curStudent);
        }
        return list;
    }

    public List<User> getTeacherListByCourseList(List<Course> courseList)
    {
        List<User> list = new ArrayList<>();
        for(Course course : courseList)
        {
            User teacher = userMapper.selectByPrimaryKey(course.getTeacherId());
            list.add(teacher);
        }
        return list;
    }

    public Group getGroupByGroupId(String groupId){
        return groupMapper.selectByPrimaryKey(groupId);
    }

    public List<User> getCurGroupMembers(List<Group_Student> gsList)
    {
        List<User> list = new ArrayList<>();
        for(Group_Student gs : gsList)
        {
            User user = userMapper.selectByPrimaryKey(gs.getStudentId());
            list.add(user);
        }
        return list;
    }

    public Course getCurrentCourse(int id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    public  List<Course> getCourseListBySCList(List<Student_Course> scList)
    {
        List<Course> list = new ArrayList<>();
        for(Student_Course sc : scList)
        {
            Course course = getCurrentCourse(sc.getCourseId());
            list.add(course);
        }
        return list;
    }

    /* group_course.groupId = group_student.groupId*/
    public Group getGroupUnderCourse(int courseId, String userId)
    {
        List<Group> courseGroupList = getGroupListByCourseId(courseId);
        for(Group courseGroup : courseGroupList)
        {
            String groupId = group_studentMapper.selectGroupIdByStudentId(userId);
            if(groupId == null){
                continue;
            }
            if(courseGroup.getGroupId().equals(groupId)){
                return courseGroup;
            }
        }

        return null;
    }


}





