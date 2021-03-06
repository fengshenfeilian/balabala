package com.managementSystem.controller;


import com.managementSystem.pojo.*;
import com.managementSystem.service.StudentService;
import com.managementSystem.service.TeacherService;
import com.managementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
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

    @Autowired
    UserService userService;

    //首页
    @RequestMapping(value = "/home")
    public String gotoIndex(Model model, HttpSession session){
        User user = (User) session.getAttribute("currentUser");

        //查询学生所选课程下是否有作业要过期
        List<Student_Course> scList = studentService.getCourseListByUserId(user.getUserId());
        int count=0;
        for(Student_Course sc:scList){
            List<Assignment> assignments = teacherService.getAssignments(sc.getCourseId());
            Group group = studentService.getGroupUnderCourse(sc.getCourseId(),user.getUserId());
            if(group!=null && studentService.hasComingToEndAssignment(assignments,group.getGroupId()))
                count++;
        }
        User studnet = studentService.getUserById(user.getUserId());
        model.addAttribute("count",count);
        model.addAttribute("student",studnet);
        return "student/home";
    }
/* *****************************************课程模块************************************************************ */
    //课程页
    @RequestMapping(value = "/course")
    public String gotoCourse(HttpSession session,HttpServletRequest request, Model model){
        User user = (User) session.getAttribute("currentUser");
        //查看课程权限
        if(!userService.Authenticate(user.getRoleId(),"UC31")){
            model.addAttribute("message","查看课程权限不足！");
            return "student/error";
        }
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
        //查看课程权限
        if(!userService.Authenticate(user.getRoleId(),"UC31")){
            model.addAttribute("message","查看课程权限不足！");
            return "student/error";
        }
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

    //课程->课程详细信息->作业要求->查看最近一次提交的作业
    @RequestMapping(value = "/goGroupAssignment")
    public String goGroupAssignment(HttpServletRequest request, Model model,HttpSession session)
    {
        User user = (User) session.getAttribute("currentUser");
        //查看作业权限
        if(!userService.Authenticate(user.getRoleId(),"UC32")){
            model.addAttribute("message","查看作业权限不足！");
            return "student/error";
        }
        String groupId = request.getParameter("groupId");
        String cId = request.getParameter("courseId");
        Integer courseId = Integer.parseInt(cId);
        List<Group_Assignment> ga = studentService.getGroupAssignmentByGroupId(groupId);
        //查询该课程下的作业要求
        List<Assignment> assignments = teacherService.getAssignments(courseId);
        List<Boolean> notOverTime = studentService.judgeOvertimeByAssignment(assignments);
        //查询该课程下的待交作业要求
        List<Assignment>  comingToEndAssignments = studentService.getComingToEndAssignment(assignments,groupId);
        model.addAttribute("group_assignment",ga);
        model.addAttribute("assignments",assignments);
        model.addAttribute("comingToEndAssignments",comingToEndAssignments);
        model.addAttribute("notOverTime",notOverTime);
        return "student/browseAssignment";
    }

/* *****************************************作业模块************************************************************ */
    //进入作业页
    @RequestMapping(value = "/assignment")
    public String gotoAssignment(HttpSession session, Model model){
        User user = (User) session.getAttribute("currentUser");
        //查看作业权限
        if(!userService.Authenticate(user.getRoleId(),"UC32")){
            model.addAttribute("message","查看作业权限不足！");
            return "student/error";
        }
        List<Group_Student> gsList = studentService.getGroupStudent(user.getUserId());
        List<Course> course = studentService.getCourseByGroupStudentList(gsList);

        //查询该课程下是否有作业要过期
        List<Student_Course> scList = studentService.getCourseListByUserId(user.getUserId());
        List<Boolean> hasComingToEndAssignment = new ArrayList<>();
        for(Course c:course){
            List<Assignment> assignments = teacherService.getAssignments(c.getCourseId());
            Group group = studentService.getGroupUnderCourse(c.getCourseId(),user.getUserId());
            hasComingToEndAssignment.add(studentService.hasComingToEndAssignment(assignments,group.getGroupId()));
        }

        model.addAttribute("hasComingToEndAssignment",hasComingToEndAssignment);
        model.addAttribute("group_student",gsList);
        model.addAttribute("course",course);
        return "student/assignment";
    }

    //查看作业列表
    @RequestMapping(value = "/browseAssignment")
    public String gotoBrowseAssignment(HttpServletRequest request, Model model,HttpSession session){
        User user = (User) session.getAttribute("currentUser");
        //查看成绩权限
        if(!userService.Authenticate(user.getRoleId(),"UC36")){
            model.addAttribute("message","查看成绩权限不足！");
            return "student/error";
        }
        String groupId = request.getParameter("groupId");
        String cId = request.getParameter("courseId");
        Integer courseId = Integer.parseInt(cId);
        List<Group_Assignment> ga = studentService.getGroupAssignmentByGroupId(groupId);
        //查询该课程下的作业要求
        List<Assignment> assignments = teacherService.getAssignments(courseId);
        List<Boolean> notOverTime = studentService.judgeOvertimeByAssignment(assignments);
        //查询该课程下的待交作业要求
        List<Assignment>  comingToEndAssignments = studentService.getComingToEndAssignment(assignments,groupId);
        model.addAttribute("group_assignment",ga);
        model.addAttribute("assignments",assignments);
        model.addAttribute("comingToEndAssignments",comingToEndAssignments);
        model.addAttribute("notOverTime",notOverTime);
        return "student/browseAssignment";
    }

    //进入作业上传页
    @RequestMapping(value = "/uploadAssignment")
    public String gotoUploadAssignment(@RequestParam(value = "assignmentId",required = false) String assignmentId,
                                       @RequestParam(value = "groupId",required = false)String groupId,
                                       HttpServletRequest request,HttpSession session,Model model) {
        User user = (User) session.getAttribute("currentUser");
        //上传及重复上传权限
        if(!userService.Authenticate(user.getRoleId(),"UC34") && !userService.Authenticate(user.getRoleId(),"UC35")){
            model.addAttribute("message","提交作业权限不足！");
            return "student/error";
        }

        //作业号校验
        if(studentService.existAssignment(assignmentId)) {
            if(studentService.existGroupAssignment(assignmentId,groupId)){
                model.addAttribute("hasSubmitted",1);
            }
        }
        return "student/uploadAssignment";
    }

    //作业上传(成功：跳转至assignment，失败则刷新uploadAssignment)
    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public  String uploadAssignment(@RequestParam(value = "assignmentId") String assignmentId,
                                    @RequestParam(value = "groupId")String groupId,
                                    @RequestParam(value = "title")String title,
                                    @RequestParam(value = "body")MultipartFile file,
                                    Model model, HttpSession session, HttpServletRequest request)throws ParseException
    {
        //Group_Assignment ga = new Group_Assignment();
        User user = (User) session.getAttribute("currentUser");
        //上传及重复上传权限
        if(!userService.Authenticate(user.getRoleId(),"UC34") && !userService.Authenticate(user.getRoleId(),"UC35")){
            model.addAttribute("message","提交作业权限不足！");
            return "student/error";
        }



        Assignment assignment = teacherService.getCurrentAssignment(assignmentId);

        String userGroupId = studentService.getGroupIdByStudentId(user.getUserId(),assignment.getCourseId());
        Group group = studentService.getGroupByGroupId(groupId);
        Course course = studentService.getCurrentCourse(group.getCourseId());
        if(!group.getLeaderId().equals(user.getUserId())){
            model.addAttribute("message","非组长不能提交作业！");
            return "student/error";
        }
        if(group.getGroupMemberNum()<course.getGroupCapacityMin() || group.getGroupMemberNum()>course.getGroupCapacityMax()){
            model.addAttribute("message","小组人数不符合要求！");
            return "student/error";
        }
        if(course.getIsEnd()==1){
            model.addAttribute("message","课程已结束，无法提交！");
            return "student/error";
        }
        //小组号校验 && 作业号校验
        if(userGroupId.equals(groupId) && studentService.existAssignment(assignmentId)){
            //如果已有<作业号，小组号>的作业，那么先删除该作业
            if(studentService.existGroupAssignment(assignmentId,groupId)){
                studentService.deleteGroupAssignment(assignmentId,groupId);
            }
            String rootPath = "assignments/"+ groupId + "-" + assignmentId + "-" + title  + "/";
            //上传(学生)作业
            String filename = file.getOriginalFilename();
            try {

                File destFile = new File(rootPath + filename);
                if(!destFile.getParentFile().exists()){
                    destFile.mkdirs();
                }
                file.transferTo(destFile);
            }catch (Exception e){
                e.printStackTrace();
                model.addAttribute("message","文件上传失败");
                return "student/error";
            }
            //添加数据库记录
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            Date date = new Date();
            df.format(date);
            Group_Assignment ga = new Group_Assignment();
            ga.setAssignmentId(assignmentId);
            ga.setGroupId(groupId);
            ga.setTitle(title);
            ga.setBody(rootPath + filename);
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
        //创建及小组管理权限
        if(!userService.Authenticate(user.getRoleId(),"UC33") ){
            model.addAttribute("message","创建小组权限不足！");
            return "student/error";
        }
        List<Group_Student> gsList = studentService.getGroupListByStudentId(user.getUserId());
        model.addAttribute("gsList",gsList);
        List<Group> groupList = studentService.getGroupListByGSList(gsList);
        List<Boolean> isGroupLeader = studentService.checkGroupLeader(groupList,user.getUserId());
        model.addAttribute("isGroupLeader",isGroupLeader);
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
        User user = (User)session.getAttribute("currentUser");
        //创建及小组管理权限
        if(!userService.Authenticate(user.getRoleId(),"UC33") ){
            model.addAttribute("message","查看小组权限不足！");
            return "student/error";
        }

        //小组信息
        Group curGroup = teacherService.getGroup(groupId);
        model.addAttribute("curGroup",curGroup);
        Course course = studentService.getCurrentCourse(curGroup.getCourseId());
        model.addAttribute("curCourse",course);
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
        //是否是组长
        Boolean isGroupLeader = false;
        if(user.getUserId().equals(curGroup.getLeaderId())){
            isGroupLeader = true;
        }
        model.addAttribute("isGroupLeader",isGroupLeader);
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
        //创建及小组管理权限
        if(!userService.Authenticate(user.getRoleId(),"UC33") ){
            model.addAttribute("message","创建小组权限不足！");
            return "student/error";
        }

        //判断学生是否选了该课
        if(studentService.courseNotSelected(user.getUserId(),courseId)){
            model.addAttribute("message","您未选择该课");
            return "student/error";
        }

        List<Group_Student> studentGroupList = studentService.getGroupListByStudentId(user.getUserId());
        List<Group> courseGroupList = studentService.getGroupListByCourseId(courseId);
        if(!studentService.groupNotNull(studentGroupList,courseGroupList)){ //可以在该课程下创建小组
            studentService.insertGroup(courseId, groupName, user.getUserId());
            return "redirect:/student/groupList";
        }


        return "redirect:/student/addGroup";
    }

    //小组【解散】
    /*
      0. 只有组长可以删除小组(在前端完成校验)
    * 1. 删除group_course表下数据
    * 2. 删除group_student表下数据
    * 3. 删除group_assignment表下数据
    * */
    @RequestMapping(value = "/deleteGroup")
    public String gotoDeleteGroup(@RequestParam(value = "groupId")String groupId,HttpSession session)
    {
        User user = (User) session.getAttribute("currentUser");

        Group curGroup = studentService.getGroupByGroupId(groupId);
        if(curGroup.getLeaderId().equals(user.getUserId())){//只有组长可以删除
            studentService.deleteGroup(curGroup);
        }
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
        //创建及小组管理权限
        if(!userService.Authenticate(user.getRoleId(),"UC33") ){
            model.addAttribute("message","增加成员权限不足！");
            return "student/error";
        }

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

    //小组成员修改
    @RequestMapping(value = "/updateGroupMember")
    public String gotoUpdateGroupMember(@RequestParam(value = "studentId") String studentId,
                                        @RequestParam(value = "groupId")String groupId,
                                        Model model, HttpSession session,HttpServletRequest request)throws ParseException
    {
        return "student/updateGroupMember";
    }

    //小组成员 : 设置成绩
    @RequestMapping(value = "/updateGroupMemberScore",method = RequestMethod.POST)
    public String gotoupdateScore(@RequestParam(value = "groupId")String groupId,
                                  @RequestParam(value = "studentId")String studentId,
                                  @RequestParam(value = "grade")String grade,
                                  HttpServletRequest request,
                                  Model model)throws ParseException
    {
        Integer curGrade = Integer.parseInt(grade);
        if((curGrade >= 60) && curGrade <= 100){//一个合法的成绩
            studentService.updateScoreByGroupMember(groupId,studentId,curGrade);
            return "redirect:/student/groupInfo?groupId=" + groupId;
        }
        else {
            model.addAttribute("message","不合法的分数！");
            return "student/error";
        }

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
        //创建及小组管理权限
        if(!userService.Authenticate(user.getRoleId(),"UC33") ){
            model.addAttribute("message","成员删除权限不足！");
            return "student/error";
        }

        if(user.getUserId().equals(studentId)){ //不能自己删除自己
            String urlParam = groupId.toString();
            return "redirect:/student/groupInfo?groupId=" + urlParam;
        }
        //获取当前小组
        Group group = studentService.getGroupByGroupId(groupId);
        //获取小组所属课程
        Course course = teacherService.getCurrentCourse(group.getCourseId());
        if(user.getUserId().equals(group.getLeaderId())) {//如果是组长:
            studentService.deleteGroupMember(groupId,studentId);
        }

        String urlParam = groupId.toString();
        return "redirect:/student/groupInfo?groupId=" + urlParam;
    }


}
