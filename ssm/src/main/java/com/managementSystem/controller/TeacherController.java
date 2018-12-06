package com.managementSystem.controller;

import com.managementSystem.pojo.*;
import com.managementSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.managementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
@SessionAttributes("user")//将名为user的属性加入session中，这样保证了session中存在User对象
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //创建课程
    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
    public String createCourse(@RequestParam(value = "courseName")String courseName,
                               @RequestParam(value = "description")String description,
                               @RequestParam(value = "minNum") String minNum,
                               @RequestParam(value = "maxNum") String maxNum,
                               @RequestParam(value = "groupPrefix") String groupPrefix,
                               Model model, HttpSession session, HttpServletRequest request){
        Course course = new Course();
        User user = (User) session.getAttribute("currentUser");
        course.setCourseName(courseName);
        Date date = new Date();
        course.setCreateTime(date);
        if(minNum == null) System.out.println("min is null");
        int min = Integer.parseInt(minNum);
        course.setGroupCapacityMin(min);
        int max = Integer.parseInt(maxNum);
        course.setGroupCapacityMax(max);
        int prefix = Integer.parseInt(groupPrefix);
        course.setGroupPrefix(prefix);
        course.setCourseDescription(description);
        course.setTeacherId(user.getUserId());
        course.setIsEnd(0);
        teacherService.createNewCourse(course);
        model.addAttribute("message","创建成功");
//        model.addAttribute("courses", teacherService.getAllCourses(user.getUserId()));
        model.addAttribute("course", course);
        request.getSession().setAttribute("currentCourse", course);
        //此处返回页面待定
        return "teacher/course";
    }

    @RequestMapping(value = "/goCreateCourse")
    public String goCreateCourse()
    {
        return "teacher/createCourse";
    }

    @RequestMapping(value = "/addStudentByFile", method = RequestMethod.POST)
    public String addStudentByFile(@RequestParam(value="filename") MultipartFile file, Model model, HttpSession session)
    {
        if(file==null) return null;
        //获取文件名
        String name = file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0) return null;
        //批量导入。参数：文件名，文件。
        User user = (User) session.getAttribute("currentUser");
        Course course = (Course) session.getAttribute("currentCourse");
//        Integer courseId = teacherService.getCourseId(course.getCourseName(), user.getUserId());
        Integer courseId = course.getCourseId();
        teacherService.addUserByFile(name, file, courseId);
        model.addAttribute("course", course);
        return "teacher/course";
    }

    @RequestMapping(value = "/addDailyScore", method = RequestMethod.POST)
    public String addDailyScore(@RequestParam(value="filename") MultipartFile file, Model model, HttpSession session)
    {
        if(file==null) return null;
        //获取文件名
        String name = file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0) return null;
        //批量导入。参数：文件名，文件。
        User user = (User) session.getAttribute("currentUser");
        Course course = (Course) session.getAttribute("currentCourse");
//        Integer courseId = teacherService.getCourseId(course.getCourseName(), user.getUserId());
        Integer courseId = course.getCourseId();
        teacherService.addDailyScore(name, file, courseId);
        model.addAttribute("msg", "导入平时成绩成功");
        model.addAttribute("course", course);
        return "teacher/course";
    }

    @RequestMapping(value = "/goCourse")
    public String goCourse(HttpServletRequest request, Model model)
    {
        String courseId = request.getParameter("courseId");
        int id = Integer.parseInt(courseId);
        Course course = teacherService.getCurrentCourse(id);
        model.addAttribute("course", course);
        List<Assignment> assignments = teacherService.getAssignments(id);
        model.addAttribute("assignments", assignments);
        request.getSession().setAttribute("currentCourse", course);
        return "teacher/course";
    }

    @RequestMapping(value = "/goAddAssignment")
    public String goAddAssignment(Model model)
    {
        return "teacher/addAssignment";
    }

    @RequestMapping(value = "/addAssignment", method = RequestMethod.POST)
    public String addAssignment(@RequestParam(value = "assignmentName") String name,
                                @RequestParam(value = "description")String description,
                                @RequestParam(value = "deadline")String deadline,
                                @RequestParam(value = "percentage") String percentage,
                                Model model, HttpSession session, HttpServletRequest request) throws ParseException {
        Assignment assignment = new Assignment();
        assignment.setTitle(name);
        assignment.setBody(description);
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date date = format.parse(deadline);
        assignment.setDeadline(date);
        Date nowDate = new Date();
        assignment.setReleaseTime(nowDate);
        Integer percent = Integer.parseInt(percentage);
        assignment.setPercent(percent);
        Course course = (Course) session.getAttribute("currentCourse");
        assignment.setCourseId(course.getCourseId());
        String prefix = course.getCourseId().toString();
        long assignNumber = teacherService.getAssignmentNumber(course.getCourseId());
        String assignId = prefix + String.valueOf(assignNumber);
        assignment.setAssignmentId(assignId);
        teacherService.addAssignment(assignment);
        List<Assignment> assignments = teacherService.getAssignments(course.getCourseId());
        model.addAttribute("assignments", assignments);
        return "teacher/course";
    }
/*
    @RequestMapping(value = "/showAssignments")
    public String showAssignments(HttpSession httpSession, HttpServletRequest request, Model model)
    {
        Course course = (Course) httpSession.getAttribute("currentCourse");
        User user = (User) httpSession.getAttribute("currentUser");
        Integer courseId = course.getCourseId();
        List<Assignment> assignments = teacherService.getAssignments(courseId);
        model.addAttribute("assignments", assignments);
        return "teacher/assignments";
    }
*/
    @RequestMapping(value = "/showSubmitedAssignments")
    public String showSubmitedAssignments(HttpSession httpSession, HttpServletRequest request, Model model)
    {
        String assignmentId = request.getParameter("assignmentId");
        Assignment assignment = teacherService.getCurrentAssignment(assignmentId);
        List<Group_Assignment> group_assignments = teacherService.getSubmitedAssignments(assignmentId);
        for (Group_Assignment group_assignment : group_assignments)
        {
            Group group = teacherService.getGroup(group_assignment.getGroupId());
            group_assignment.setGroupName(group.getGroupName());
            User user = teacherService.getStudent(group_assignment.getGroupId());
            group_assignment.setStudentName(user.getUserName());
        }
        model.addAttribute("group_assignments", group_assignments);
        model.addAttribute("assignment", assignment);
        return "teacher/assignments";
    }

    @RequestMapping(value = "/showAssignmentsByCondition", method = RequestMethod.POST)
    public String showAssignmentsByCondition(@RequestParam(value = "assignmentName") String title,
                                             @RequestParam(value = "groupId")String groupName,
                                             Model model, HttpSession session, HttpServletRequest request)
    {
        List<Group_Assignment> group_assignments = teacherService.getAssignmentsByCondition(title, groupName);
        model.addAttribute("group_assignments", group_assignments);
        return "teacher/assignments";
    }

    @RequestMapping(value = "/goScore")
    public String score(HttpServletRequest request, Model model)
    {
        String assignmentId = request.getParameter("assignmentId");
        String groupId = request.getParameter("groupId");
        Assignment assignment = teacherService.getCurrentAssignment(assignmentId);
        Group group = teacherService.getGroup(Integer.parseInt(groupId));
        Group_Assignment group_assignment = teacherService.getCurrentGroupAssignemnt(Integer.parseInt(groupId),
                assignmentId);
        List<User> members = new ArrayList<>();
        List<Group_Student> group_students = teacherService.getGroupStudents(Integer.parseInt(groupId));
        for (Group_Student group_student : group_students)
        {
            User user = teacherService.getStudentsInGroup(group_student.getStudentId());
            members.add(user);
        }
        model.addAttribute("assignment", assignment);
        model.addAttribute("group", group);
        model.addAttribute("group_assignment", group_assignment);
        model.addAttribute("members", members);
        request.getSession().setAttribute("current_group_assignment", group_assignment);
        return "teacher/score";
    }

    @RequestMapping(value = "/scoreGroup", method=RequestMethod.POST)
    public String scoreGroup(@RequestParam(value = "grade") String grade, HttpSession httpSession,
                             HttpServletRequest request,
                             Model model)
    {
        Group_Assignment group_assignment = (Group_Assignment) httpSession.getAttribute("current_group_assignment");
        group_assignment.setScore(Integer.parseInt(grade));
        teacherService.updateGroupGrade(group_assignment);
        String assignmentId = group_assignment.getAssignmentId();
        Assignment assignment = teacherService.getCurrentAssignment(assignmentId);
        List<Group_Assignment> group_assignments = teacherService.getSubmitedAssignments(assignmentId);
        for (Group_Assignment for_group_assignment : group_assignments)
        {
            Group group = teacherService.getGroup(for_group_assignment.getGroupId());
            for_group_assignment.setGroupName(group.getGroupName());
            User user = teacherService.getStudent(for_group_assignment.getGroupId());
            for_group_assignment.setStudentName(user.getUserName());
        }
        model.addAttribute("group_assignments", group_assignments);
        model.addAttribute("assignment", assignment);
        return "teacher/assignments";
    }

    @RequestMapping(value = "/createScore")
    public String createScore(HttpSession session, HttpServletRequest request, Model model)
    {
        Course course = (Course) session.getAttribute("currentCourse");
        User user = (User) session.getAttribute("currentUser");
        Integer courseId = teacherService.getCourseId(course.getCourseName(), user.getUserId());
        List<Student_Course> students = teacherService.getAllStudents(courseId);
        for (Student_Course student : students)
        {
            Student_Course student_course = new Student_Course();
            double grade = 0.0;
            String studentId = student.getStudentId();
            Integer groupId = teacherService.getGroupID(courseId, studentId);
            Integer groupGrade = teacherService.getGroupGrade(courseId, studentId);
            List<Group_Assignment> group_assignments = teacherService.getGroupAssignemnt(groupId);
            for (Group_Assignment group_assignment : group_assignments)
            {
                String assignmentId = group_assignment.getAssignmentId();
                Integer score = group_assignment.getScore();
                Integer percent = teacherService.getAssignmentPercent(assignmentId);
                grade = grade + (float)score * percent / 100;
            }
            grade = grade * groupGrade / 100;
            student_course.setStudentId(studentId);
            student_course.setCourseId(courseId);
            student_course.setAssignmentGrade((int)grade);
            teacherService.updateGrade(student_course);
        }
        return "teacher/course";
    }

    @RequestMapping(value = "showAllStudents")
    public String showAllStudents(HttpSession httpSession, HttpServletRequest request, Model model)
    {
        Course course = (Course) httpSession.getAttribute("currentCourse");
        User user = (User) httpSession.getAttribute("currentUser");
        Integer courseId = teacherService.getCourseId(course.getCourseName(), user.getUserId());
        List<Student_Course> student_courses = teacherService.getAllStudentsInfo(courseId);
        model.addAttribute("student_courses", student_courses);
        model.addAttribute("course", course);
        List<User > students = teacherService.getAllUsers(student_courses);
        model.addAttribute("students", students);
        return "teacher/students";
    }
}
