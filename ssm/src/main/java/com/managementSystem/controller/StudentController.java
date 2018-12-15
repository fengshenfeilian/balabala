package com.managementSystem.controller;


import com.managementSystem.pojo.*;
import com.managementSystem.service.StudentService;
import com.managementSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/student")
@SessionAttributes("user")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;


    //首页
    @RequestMapping(value = "/home")
    public String gotoIndex(Model model, HttpSession session){
        User user = (User) session.getAttribute("currentUser");
        User studnet = studentService.getUserById(user.getUserId());
        model.addAttribute("student",studnet);
        return "student/home";
    }
/* *****************************************课程模块************************************************************ */
    //课程页
    @RequestMapping(value = "/course")
    public String gotoCourse(HttpSession session,HttpServletRequest request, Model model){
        User user = (User) session.getAttribute("currentUser");
        List<Student_Course> scList = studentService.getCourseListByUserId(user.getUserId());
        List<Course> courseList = studentService.getCourseListBySCList(scList);
        List<User> teacherList = studentService.getTeacherListByCourseList(courseList);
        model.addAttribute("studentCourse",scList);
        model.addAttribute("courseList",courseList);
        model.addAttribute("teacherList",teacherList);
        return "student/course";
    }

    //课程详细信息
    /*
        1.显示该课程信息
        2.显示当前用户(在该课程下的)小组信息

    */
    @RequestMapping(value = "/courseInfo")
    public String gotoCourseInfo(HttpServletRequest request, Model model, HttpSession session){
        User user = (User) session.getAttribute("currentUser");
        String id = request.getParameter("courseId");
        int courseId = Integer.parseInt(id);
        //group可能为空(该学生在该课程下还未拥有小组)
        Group group = studentService.getGroupUnderCourse(courseId, user.getUserId());
        Course course = teacherService.getCurrentCourse(courseId);
        User teacher = studentService.getUserById(course.getTeacherId());
        List<Assignment> curCourseAssignment = teacherService.getAssignments(courseId);
        model.addAttribute("curCourseAssignment",curCourseAssignment);
        model.addAttribute("course",course);
        model.addAttribute("currentCourseTeacherName",teacher.getUserName());
        model.addAttribute("curGroup",group);

        return "student/courseInfo";
    }

    //未完成：
    //课程->课程详细信息->作业要求->查看最近一次提交的作业
    @RequestMapping(value = "/goGroupAssignment")
    public String goGroupAssignment(@RequestParam(value = "groupId")Integer groupId)
    {
        return "redirect:/student/browseAssignment";
    }

/* *****************************************作业模块************************************************************ */
    //进入作业页
    @RequestMapping(value = "/assignment")
    public String gotoAssignment(HttpSession session, Model model){
        User user = (User) session.getAttribute("currentUser");
        List<Group_Student> gsList = studentService.getGroupStudent(user.getUserId());
        List<Course> course = studentService.getCourseByGroupStudentList(gsList);
        model.addAttribute("group_student",gsList);
        model.addAttribute("course",course);
        return "student/assignment";
    }

    //查看作业列表
    //还应该能查看作业要求，不然交作业从何谈起
    @RequestMapping(value = "/browseAssignment")
    public String gotoBrowseAssignment(HttpServletRequest request, Model model){
        String groupId = request.getParameter("groupId");
        String cId = request.getParameter("courseId");
        Integer courseId = Integer.parseInt(cId);

        List<Group_Assignment> ga = studentService.getGroupAssignmentByGroupId(groupId);
        //查询该课程下的作业要求
        List<Assignment> assignments = studentService.getAssignments(courseId);
        model.addAttribute("group_assignment",ga);
        model.addAttribute("assignments",assignments);
        return "student/browseAssignment";
    }

    //进入作业上传页
    @RequestMapping(value = "/uploadAssignment")
    public String gotoUploadAssignment(){
        return "student/uploadAssignment";
    }

    //作业上传(成功：跳转至assignment，失败则刷新uploadAssignment)
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public  String uploadAssignment(@RequestParam(value = "assignmentId") String assignmentId,
                                    @RequestParam(value = "groupId")String groupId,
                                    @RequestParam(value = "title")String title,
                                    @RequestParam(value="body")String body,
                                    Model model, HttpSession session, HttpServletRequest request)throws ParseException
    {
        //Group_Assignment ga = new Group_Assignment();
        User user = (User) session.getAttribute("currentUser");

        String userGroupId = studentService.getGroupIdByStudentId(user.getUserId());
        //小组号校验 && 作业号校验
        if(userGroupId.equals(groupId) && studentService.existAssignment(assignmentId)){
            //如果已有<作业号，小组号>的作业，那么先删除该作业
            if(studentService.existGroupAssignment(assignmentId,groupId)){
                studentService.deleteGroupAssignment(assignmentId,groupId);
            }
            //上传(学生)作业
            String rootPath = "C:\\Users\\marco\\Desktop\\balabala\\assignment\\";
            //添加数据库记录
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date date = new Date();
            df.format(date);
            Group_Assignment ga = new Group_Assignment();
            ga.setAssignmentId(assignmentId);
            ga.setGroupId(groupId);
            ga.setTitle(title);
            ga.setBody(rootPath + body);
            ga.setSubmissionTime(date);
            studentService.insertGroupAssignment(ga);
            return  "redirect:/student/assignment";
        }
        else{
            return "redirect:/student/uploadAssignment";
        }
    }
/* *****************************************小组模块************************************************************ */
/*可增加功能：组员 - 退出小组
             组长 - 删除小组
*/
    //小组列表
    @RequestMapping(value = "/groupList")
    public String gotoGroupList(Model model,HttpSession session )
    {
        User user = (User) session.getAttribute("currentUser");
        List<Group_Student> gsList = studentService.getGroupListByStudentId(user.getUserId());
        /*for(Group_Student gs:gsList){
            System.out.println(gs.getGroupId());
            System.out.println(gs.getStudentId());
        }*/
        model.addAttribute("gsList",gsList);
        List<Group> groupList = studentService.getGroupListByGSList(gsList);
        for(Group group:groupList){
            System.out.println(group.getGroupId());
            System.out.println(group.getCourseId());
        }
        model.addAttribute("groupList",groupList);
        return "student/groupList";
    }

    //进入小组信息页
    //groupId
    @RequestMapping(value = "/groupInfo")
    public String gotoGroupInfo(Model model,HttpSession session,HttpServletRequest request)
    {
        String groupId = request.getParameter("groupId");

        //小组信息
        Group curGroup = teacherService.getGroup(groupId);
        model.addAttribute("curGroup",curGroup);
        //小组成员列表
        List<Group_Student> gsList = teacherService.getGroupStudents(groupId);
        List<User> curGroupMembers = studentService.getCurGroupMembers(gsList);
        model.addAttribute("gsList",gsList);
        model.addAttribute("curGroupMembers",curGroupMembers);
        //可选学生列表
        Integer courseId = curGroup.getCourseId();
        List<User> courseStudentList = studentService.getAllCourseStudent(courseId); //当前课程的学生
        List<User> courseStudentListWithGroup = studentService.getCourseStudentWithGroup(courseId);//当前课程有小组的学生
        List<User> availableStudent = studentService.userRemoveCurrentCourse(courseStudentList,courseStudentListWithGroup);
        model.addAttribute("availableStudent",availableStudent);
        return "student/groupInfo";
    }


    //进入创建小组页
    @RequestMapping(value = "/addGroup")
    public String gotoAddGroup(@RequestParam(value = "courseId") String courseId,Model model)throws ParseException
    {
        Integer id = Integer.parseInt(courseId);
        model.addAttribute("curCourseId",id);

        return "student/addGroup";
    }


    /*
    功能:创建小组<courseId,groupName,studentId>
    判断该学生在该课程下是否已有小组：
        若该学生未选择该课，则不能创建小组，所以此功能最好从学生选课信息页跳转到创建小组或小组信息页，且创建小组时不能修改课程id。
        1.找到该课程的所有小组courseGroup
        2.找到学生所属的所有小组studentGroup
        3.如果courseGroup和studentGroup交集不为空，那么该学生已有小组
    */
    @RequestMapping(value = "/addNewGroup")
    public String gotoAddNewGroup(@RequestParam(value = "courseId") Integer courseId,
                               @RequestParam(value = "groupName")String groupName,
                               Model model, HttpSession session,HttpServletRequest request)throws ParseException
    {
        User user = (User) session.getAttribute("currentUser");
        //判断学生是否选了该课
        if(studentService.courseNotSelected(user.getUserId(),courseId)) return "redirect:/student/addGroup";

        List<Group_Student> studentGroupList = studentService.getGroupListByStudentId(user.getUserId());
        List<Group> courseGroupList = studentService.getGroupListByCourseId(courseId);
        if(!studentService.groupNotNull(studentGroupList,courseGroupList)){ //可以在该课程下创建小组
            studentService.insertGroup(courseId, groupName, user.getUserId());
            return "redirect:/student/groupList";
        }
        return "redirect:/student/addGroup";
    }

    //小组【解散】
    @RequestMapping(value = "/deleteGroup")
    public String gotoDeleteGroup()
    {
        return "redirect:/student/groupList";
    }

    //小组成员【添加】
    //groupId
    @RequestMapping(value = "/addGroupMember")
    public String gotoAddGroupMember(@RequestParam(value = "studentId") String studentId,
                                     @RequestParam(value = "groupId")String groupId,
                                     Model model, HttpSession session,HttpServletRequest request)throws ParseException
    {
        //获取当前学生用户
        User user = (User) session.getAttribute("currentUser");
        //获取当前小组
        Group group = studentService.getGroupByGroupId(groupId);
        //获取小组所属课程
        Course course = teacherService.getCurrentCourse(group.getCourseId());
        if(user.getUserId().equals(group.getLeaderId())){//如果是组长:
            if(studentService.getCountGroupMember(groupId) < course.getGroupCapacityMax()){ //小组人数 < 小组最大人数:
                studentService.insertGroupMember(groupId,studentId); //小组添加一个成员
            }
        }
        String urlParam = groupId.toString();
        return "redirect:/student/groupInfo?groupId=" + urlParam;
    }

    //小组成员【删除】
    //groupId
    @RequestMapping(value = "/deleteGroupMember")
    public String gotoDeleteGroupMember(@RequestParam(value = "studentId") String studentId,
                                        @RequestParam(value = "groupId")String groupId,
                                        Model model, HttpSession session,HttpServletRequest request)throws ParseException
    {
        //获取当前学生用户
        User user = (User) session.getAttribute("currentUser");
        if(user.getUserId().equals(studentId)){ //不能自己删除自己
            String urlParam = groupId.toString();
            return "redirect:/student/groupInfo?groupId=" + urlParam;
        }
        //获取当前小组
        Group group = studentService.getGroupByGroupId(groupId);
        //获取小组所属课程
        Course course = teacherService.getCurrentCourse(group.getCourseId());
        if(user.getUserId().equals(group.getLeaderId())) {//如果是组长:
            if(studentService.getCountGroupMember(groupId) > course.getGroupCapacityMin()){ //小组人数 > 小组最小人数:
                studentService.deleteGroupMember(groupId,studentId);
            }
        }

        String urlParam = groupId.toString();
        return "redirect:/student/groupInfo?groupId=" + urlParam;
    }


}
