package com.managementSystem.controller;

import com.managementSystem.pojo.*;
import com.managementSystem.service.TeacherService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.managementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
@SessionAttributes("user")//将名为user的属性加入session中，这样保证了session中存在User对象
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    //进入首页
    @RequestMapping(value = "/index")
    public String gotoIndex(Model model, HttpSession session ){
        User user = (User) session.getAttribute("currentUser");
        List<Course> courses = teacherService.getAllCourses(user.getUserId());
        model.addAttribute("courses", courses);
        model.addAttribute("user", user);
        return "teacher/index";
    }

    //创建课程
    @RequestMapping(value = "/createCourse", method = RequestMethod.POST)
    public String createCourse(@RequestParam(value = "courseName")String courseName,
                               @RequestParam(value = "description")String description,
                               @RequestParam(value = "minNum") String minNum,
                               @RequestParam(value = "maxNum") String maxNum,
                               @RequestParam(value = "startTime") String startTime,
                               Model model, HttpSession session, HttpServletRequest request) throws ParseException {
        Course course = new Course();
        User user = (User) session.getAttribute("currentUser");
        course.setCourseName(courseName);
        DateFormat format = new SimpleDateFormat("yyyy-MM");
        Date date = format.parse(startTime);
        course.setCreateTime(date);
        if(minNum == null) System.out.println("min is null");
        int min = Integer.parseInt(minNum);
        course.setGroupCapacityMin(min);
        int max = Integer.parseInt(maxNum);
        course.setGroupCapacityMax(max);
        Calendar cale = null;
        cale = Calendar.getInstance();
        int year = cale.get(Calendar.YEAR);
        int suffix = teacherService.getCount(user.getUserId()) + 1;
        String groupPrefix = String.valueOf(year) + String.valueOf(suffix);
        course.setGroupPrefix(groupPrefix);
        course.setCourseDescription(description);
        course.setTeacherId(user.getUserId());
        course.setIsEnd(0);
        if(teacherService.findCourse(course) == true)
        {
            model.addAttribute("message", "课程已存在");
            return "/teacher/course";
        }
        //小组前缀前加“课程id-”
        teacherService.createNewCourse(course);
        model.addAttribute("message","创建成功");
        model.addAttribute("courses", teacherService.getAllCourses(user.getUserId()));
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
        if(name==null || ("").equals(name) && size==0) return "teacher/course";
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
        if(name==null || ("").equals(name) && size==0) return "teacher/course";
        //批量导入。参数：文件名，文件。
        User user = (User) session.getAttribute("currentUser");
        Course course = (Course) session.getAttribute("currentCourse");
//        Integer courseId = teacherService.getCourseId(course.getCourseName(), user.getUserId());
        Integer courseId = course.getCourseId();
        teacherService.addDailyScore(name, file, courseId);
        model.addAttribute("message", "导入平时成绩成功");
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
        httpSession.setAttribute("currentAssignment", assignment);

        List<Group_Assignment> group_assignments = teacherService.getSubmitedAssignments(assignmentId);
        for (Group_Assignment group_assignment : group_assignments)
        {
            Group group = teacherService.getGroup(group_assignment.getGroupId());
            group_assignment.setGroupName(group.getGroupName());
            //在这里获取的是组长的id
            User user = teacherService.getStudent(group_assignment.getGroupId());
            //在这里设置了提交人
            group_assignment.setStudentName(user.getUserName());
        }
        model.addAttribute("group_assignments", group_assignments);
        model.addAttribute("assignment", assignment);
        Course course = (Course)httpSession.getAttribute("currentCourse");
        model.addAttribute("course", course);
        return "teacher/assignments";
    }

    @RequestMapping(value = "/modifyPercent", method=RequestMethod.POST)
    public String modifyPercent(@RequestParam(value = "newPercent") String newPercent, HttpSession session, Model model)
    {
        Assignment assignment = (Assignment) session.getAttribute("currentAssignment");
        assignment.setPercent(Integer.parseInt(newPercent));
        teacherService.updatePercent(assignment);
        String assignmentId = assignment.getAssignmentId();
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
        Course course = (Course)session.getAttribute("currentCourse");
        model.addAttribute("course", course);
        return "teacher/assignments";
    }

    @RequestMapping(value = "/showAssignmentsByCondition", method = RequestMethod.POST)
    public String showAssignmentsByCondition(@RequestParam(value = "assignmentName") String title,
                                             @RequestParam(value = "groupId")String groupName,
                                             Model model, HttpSession session, HttpServletRequest request)
    {
        List<Group_Assignment> group_assignments = teacherService.getAssignmentsByCondition(title, groupName);
        model.addAttribute("group_assignments", group_assignments);
        Course course = (Course)session.getAttribute("currentCourse");
        model.addAttribute("course", course);
        return "teacher/assignments";
    }

    @RequestMapping(value = "/goScore")
    public String score(HttpServletRequest request, Model model,HttpSession httpSession)
    {
        String assignmentId = request.getParameter("assignmentId");
        String groupId = request.getParameter("groupId");
        Assignment assignment = teacherService.getCurrentAssignment(assignmentId);
        Group group = teacherService.getGroup(groupId);
        Group_Assignment group_assignment = teacherService.getCurrentGroupAssignemnt(groupId,
                assignmentId);
        //在这里获取的是组长的id
        User leader = teacherService.getStudent(groupId);
        //在这里设置了提交人
        group_assignment.setStudentName(leader.getUserName());

        List<User> members = new ArrayList<>();
        List<Group_Student> group_students = teacherService.getGroupStudents(groupId);
        for (Group_Student group_student : group_students)
        {
            User user = teacherService.getStudentsInGroup(group_student.getStudentId());
            members.add(user);
        }
        Course course = (Course)httpSession.getAttribute("currentCourse");
        model.addAttribute("course", course);
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
        Course course = (Course)httpSession.getAttribute("currentCourse");
        model.addAttribute("course", course);
        return "teacher/assignments";
    }


    //计算该课程学生的作业总成绩
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
            String groupId = teacherService.getGroupID(courseId, studentId);
            //获取小组评分
            Integer groupGrade = teacherService.getGroupGrade(courseId, studentId);
            List<Group_Assignment> group_assignments = teacherService.getGroupAssignemnt(groupId);
            for (Group_Assignment group_assignment : group_assignments)
            {
                String assignmentId = group_assignment.getAssignmentId();
                Integer score = group_assignment.getScore();
                Integer percent = teacherService.getAssignmentPercent(assignmentId);
                grade = grade + (float)score * percent / 100;
            }
            //作业占80%，小组评分占20%
            grade = grade * 0.8 + groupGrade*0.2;
            student_course.setStudentId(studentId);
            student_course.setCourseId(courseId);
            student_course.setAssignmentGrade((int) grade);
            teacherService.updateGrade(student_course);
        }

        List<Student_Course> student_courses = teacherService.getAllStudentsInfo(courseId);
        model.addAttribute("student_courses", student_courses);
        model.addAttribute("course", course);
        List<User> users = teacherService.getAllUsers(student_courses);
        model.addAttribute("students", users);
        return "teacher/students";
    }

    @RequestMapping(value = "/showAllStudents")
    public String showAllStudents(HttpSession httpSession, HttpServletRequest request, Model model)
    {
        Course course = (Course) httpSession.getAttribute("currentCourse");
        User user = (User) httpSession.getAttribute("currentUser");
        Integer courseId = teacherService.getCourseId(course.getCourseName(), user.getUserId());
        List<Student_Course> student_courses = teacherService.getAllStudentsInfo(courseId);
        model.addAttribute("student_courses", student_courses);
        model.addAttribute("course", course);
        List<User> students = teacherService.getAllUsers(student_courses);
        model.addAttribute("students", students);
        return "teacher/students";
    }

    @RequestMapping(value = "/finishCourse")
    public String finishCourse(Model model, HttpSession session)
    {
        Course course = (Course) session.getAttribute("currentCourse");
        course.setIsEnd(1);
        teacherService.setCourseEnd(course);
        User user = (User) session.getAttribute("currentUser");
        List<Course> courses = teacherService.getAllCourses(user.getUserId());
        model.addAttribute("courses", courses);
        model.addAttribute("user", user);
        return "teacher/index";
    }

    @RequestMapping(value = "/scoreToExcel")
    public String scoreToExcel(Model model, HttpSession session) throws IOException {
        //excel里并没有写进数据,也没有计算学生的作业成绩
        Course course = (Course) session.getAttribute("currentCourse");
        int assignCount = teacherService.getAssignmentCount(course.getCourseId());
        System.out.println("assignCount:"+assignCount);
        String path = "D:/" + course.getCourseName() + "成绩单.xlsx";
        Workbook wb = null;
        File file = new File(path);
        Sheet sheet = null;
        if(!file.exists())
        {
            wb = new XSSFWorkbook();
            sheet = (Sheet) wb.createSheet("sheet1");
            OutputStream outputStream = new FileOutputStream(path);
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();
        }
        //若文件已存在，则此处出错
        if (sheet == null) sheet = (Sheet) wb.createSheet("sheet1");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        row.setHeight((short) 400);
        cell.setCellValue("学号");
        cell = row.createCell(1);
        cell.setCellValue("姓名");
        for(int i = 0;i < assignCount;i++)
        {
            cell = row.createCell(2*i + 2);
            cell.setCellValue("小组作业成绩" + String.valueOf(i+1));
            cell = row.createCell(2*i + 3);
            cell.setCellValue("小组评分" + String.valueOf(i+1));
        }
        cell = row.createCell(2*assignCount + 2);
        cell.setCellValue("平时成绩");
        cell = row.createCell(2*assignCount + 3);
        cell.setCellValue("总成绩");
        //获取选取该课的学生
        List<Student_Course> student_courses = teacherService.getAllStudentsInfo(course.getCourseId());
        int rowIndex = 1;
        for (Student_Course student_course : student_courses)
        {
            row = sheet.createRow(rowIndex);
            cell = row.createCell(0);
            //获取在小组中的学生
            User user = teacherService.getStudentsInGroup(student_course.getStudentId());
            cell.setCellValue(user.getUserId());
            cell = row.createCell(1);
            cell.setCellValue(user.getUserName());
            //获取学生所选课程所在的小组
            String groupId= teacherService.getGroupID(course.getCourseId(), user.getUserId());
            //获取该小组所交的作业
            //此处存在越界问题
            List<Group_Assignment> group_assignments = teacherService.getGroupAssignemnt(groupId);
            System.out.println(group_assignments.size());
            for(int i = 0;i < assignCount && i < group_assignments.size();i++)
            {
                cell = row.createCell(2*i + 2);
                cell.setCellValue(String.valueOf(group_assignments.get(i).getScore()));
                cell = row.createCell(2*i + 3);
                Integer percent = teacherService.getAssignmentPercent(group_assignments.get(i).getAssignmentId());
                cell.setCellValue(String.valueOf(group_assignments.get(i).getScore() * percent / 100));
            }
            cell = row.createCell(2*assignCount + 2);
            cell.setCellValue(String.valueOf(student_course.getDailyGrade()));
            cell = row.createCell(2*assignCount + 3);
            //平时成绩占20%，作业成绩占80%
            cell.setCellValue(String.valueOf(student_course.getDailyGrade()*0.2 + student_course.getAssignmentGrade()*0.8));
        }

        model.addAttribute("message", "生成成绩成功");
        User user = (User) session.getAttribute("currentUser");
        List<Course> courses = teacherService.getAllCourses(user.getUserId());
        model.addAttribute("courses", courses);
        model.addAttribute("user", user);
        return "teacher/index";
    }

    @RequestMapping(value = "/downloadFile")
    public void downloadFile(@RequestParam(value="filepath") String path, HttpServletResponse response, Model model) throws IOException {
        String[] tem = path.split("/");
        File file = new File("D:/down");
        if (!file.exists()) file.mkdirs();
        //此处出错
        String filepath = "D:/down/" + tem[tem.length];
        filepath = URLEncoder.encode(filepath, "UTF-8");
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
        response.addHeader("Content-Disposition", "attachment;filename=" + filepath);
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1)
        {
            out.write(len);
            out.flush();
        }
        out.close();
    }
}
