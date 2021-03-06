<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
    <title>作业管理系统</title>
    <link href="/static/css/main.css" rel="stylesheet" type="text/css" />

    <script type="text/javascript" src="/static/js/jquery.min.js"></script>

    <script type="text/javascript" src="/static/js/plugins/spinner/ui.spinner.js"></script>
    <script type="text/javascript" src="/static/js/plugins/spinner/jquery.mousewheel.js"></script>

    <script type="text/javascript" src="/static/js/jquery-ui.min.js"></script>

    <script type="text/javascript" src="/static/js/plugins/charts/excanvas.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/charts/jquery.flot.js"></script>
    <script type="text/javascript" src="/static/js/plugins/charts/jquery.flot.orderBars.js"></script>
    <script type="text/javascript" src="/static/js/plugins/charts/jquery.flot.pie.js"></script>
    <script type="text/javascript" src="/static/js/plugins/charts/jquery.flot.resize.js"></script>
    <script type="text/javascript" src="/static/js/plugins/charts/jquery.sparkline.min.js"></script>

    <script type="text/javascript" src="/static/js/plugins/forms/uniform.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.cleditor.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.validationEngine-en.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.validationEngine.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.tagsinput.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/autogrowtextarea.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.maskedinput.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.dualListBox.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/jquery.inputlimiter.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/forms/chosen.jquery.min.js"></script>

    <script type="text/javascript" src="/static/js/plugins/wizard/jquery.form.js"></script>
    <script type="text/javascript" src="/static/js/plugins/wizard/jquery.validate.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/wizard/jquery.form.wizard.js"></script>

    <script type="text/javascript" src="/static/js/plugins/uploader/plupload.js"></script>
    <script type="text/javascript" src="/static/js/plugins/uploader/plupload.html5.js"></script>
    <script type="text/javascript" src="/static/js/plugins/uploader/plupload.html4.js"></script>
    <script type="text/javascript" src="/static/js/plugins/uploader/jquery.plupload.queue.js"></script>

    <script type="text/javascript" src="/static/js/plugins/tables/datatable.js"></script>
    <script type="text/javascript" src="/static/js/plugins/tables/tablesort.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/tables/resizable.min.js"></script>

    <script type="text/javascript" src="/static/js/plugins/ui/jquery.tipsy.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.collapsible.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.prettyPhoto.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.progress.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.timeentry.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.colorpicker.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.jgrowl.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.breadcrumbs.js"></script>
    <script type="text/javascript" src="/static/js/plugins/ui/jquery.sourcerer.js"></script>

    <script type="text/javascript" src="/static/js/plugins/calendar.min.js"></script>
    <script type="text/javascript" src="/static/js/plugins/elfinder.min.js"></script>

    <script type="text/javascript" src="/static/js/custom.js"></script>

    <script type="text/javascript" src="/static/js/charts/chart.js"></script>

    <!-- Shared on MafiaShare.net  --><!-- Shared on MafiaShare.net  -->
</head>

<body>
<!-- 左侧菜单栏 -->
<div id="leftSide">
    <div class="logo"><a href="index.html"><img src="/static/images/logo.png" alt="" /></a></div>

    <div class="sidebarSep mt0"></div>

    <!-- 搜索框 -->
    <form action="" class="sidebarSearch">
        <input type="text" name="search" placeholder="search..." id="ac" />
        <input type="submit" value="" />
    </form>

    <div class="sidebarSep"></div>

    <!-- 左侧导航栏 -->
    <ul id="menu" class="nav">
        <li class="dash"><a href="index.html" title="" class="active"><span>学生管理</span></a></li>
    </ul>
</div>

<!-- 右侧区域 -->
<div id="rightSide">
    <!-- 顶部导航栏 -->
    <div class="topNav">
        <div class="wrapper">
            <div class="welcome"><a href="#" title=""><img src="/static/images/userPic.png" alt="" /></a><span>欢迎<strong>【<c:out value="${sessionScope.currentUser.userName}"/>】老师</strong>使用本系统</span></div>

            <div class="userNav">
                <ul>
                    <li><a href="${pageContext.request.contextPath}/user/toConfigPage" title="" id="userConfig"><img src="/static/images/icons/topnav/profile.png" alt="" /><span>账户</span></a></li>
                    <%--<li><a href="#" title=""><img src="/static/images/icons/topnav/settings.png" alt="" /><span>设置</span></a></li>--%>
                    <li><a href="${pageContext.request.contextPath}/user/logout" title=""><img src="/static/images/icons/topnav/logout.png" alt="" /><span>注销</span></a></li>
                </ul>
            </div>

            <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>

    <!-- 标题区 -->
    <div class="titleArea">
        <div class="wrapper">
            <div class="pageTitle">
                <h5>课程信息</h5>
                <p>课程名称:<strong>${course.courseName}</strong></p>
                <p>课程简介:<strong>${course.courseDescription}</strong></p>
                <p>课程创建时间:<strong>${course.createTime}</strong></p>
                <p>小组人数：<strong>${course.groupCapacityMin}-${course.groupCapacityMax}</strong></p>
                <p>状态：<strong>${course.isEnd==1?"已结课":"正在开课"}</strong></p>
            </div>
            <div class="clear"></div>
        </div>
    </div>

    <!-- 选项区域 -->
    <div class="statsRow">
        <div class="wrapper">
            <div class="controlB">
                <div  align="left">
                    <a href="/teacher/goAddAssignment"><button class="blueB">添加作业</button></a>
                    <a href="/teacher/showAllStudents"> <button class="redB">学生管理</button></a>
                </div>
            </div>
        </div>
    </div>

    <div class="statsRow">
        <div class="wrapper">
            <div class="controlB">
                <div  align="left">
                    <form action="${pageContext.request.contextPath}/teacher/addDailyScore" method="post" enctype="multipart/form-data">
                        <input type="file" name="filename"  value="" />
                        <input type="submit" name="" class="redB" value="上传平时成绩" />
                        <div class="clear"></div>
                    </form>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>

    <div class="statsRow">
        <div class="wrapper">
            <div class="controlB">
                <div  align="left">
                    <form action="${pageContext.request.contextPath}/teacher/addStudentByFile" method="post" enctype="multipart/form-data">
                        <input type="file" name="filename"   value="" />
                        <input type="submit" class="blueB"  value="上传学生名单" />
                    </form>
                    <div class="clear"></div>
                </div>
                <div class="clear"></div>
            </div>
        </div>
    </div>


    <!-- 学生名单 ==> 动态数据表 -->
    <div class="wrapper">
        <!-- Widgets -->
        <div class="widgets">
            <div class="widget">
                    <div class="title">
                        <img src="/static/images/icons/dark/frames.png" alt="" class="titleIcon" />
                        <h6>作业列表</h6>
                    </div>
                    <table cellpadding="0" cellspacing="0" width="100%" class="display dTable" >
                        <thead>
                        <tr>
                            <td class="sortCol"><div>作业ID<span></span></div></td>
                            <td class="sortCol"><div>作业名称<span></span></div></td>
                            <td class="sortCol"><div>基本描述<span></span></div></td>
                            <td class="sortCol"><div>提交时间<span></span></div></td>
                            <td class="sortCol"><div>发布时间<span></span></div></td>
                            <td class="sortCol"><div>分值比例<span></span></div></td>
                            <td class="sortCol"><div>操作<span></span></div></td>
                        </tr>
                        </thead>
                        <tbody align="center">
                        <c:forEach items="${assignments}" var="assignment">
                            <tr>
                                <td>${assignment.assignmentId}</td>
                                <td>${assignment.title}</td>
                                <td>${assignment.body}</td>
                                <td>${assignment.deadline}</td>
                                <td>${assignment.releaseTime}</td>
                                <td>${assignment.percent}%</td>
                                <td>
                                    <a href="/teacher/showSubmitedAssignments?assignmentId=${assignment.assignmentId}"><button class="blueB">查看已提交作业</button></a>
                                    <a href="/teacher/deleteAssignment?assignmentId=${assignment.assignmentId}"><button class="redB">删除作业</button></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
            </div>
        </div>
    </div>
    <div class="statsRow">
        <div class="wrapper">
            <div class="controlB">
                <p>说明：结课后可以结算学生总成绩以及生成成绩单，但不能再修改作业比例和学生成绩，请确保您已经完成相应评分操作。没有加入小组的学生没有本课程的成绩。</p>
                <div class="clear"></div>
            </div>
        </div>
    </div>
        <c:if test="${course.isEnd==0}">
            <div class="statsRow">
                <div class="wrapper">
                    <div class="controlB">
                        <a href="/teacher/finishCourse"><button class="blueB">结课</button></a>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
        </c:if>
        <c:if test="${course.isEnd==1}">
            <div class="statsRow">
                <div class="wrapper">
                    <div class="controlB">
                        <a href="/teacher/finishCourse"><button class="blueB">取消结课</button></a>
                        <a href="/teacher/createScore"><button class="blueB">计算作业总成绩</button></a>
                        <a href="/teacher/scoreToExcel"><button class="blueB">生成并下载成绩单</button></a>
                        <div class="clear"></div>
                    </div>
                </div>
            </div>
        </c:if>
    </div>

    <!-- Footer line -->
    <div id="footer">
        <div class="wrapper">All rights reserved by <a href="http://hashmap.me">Marco Hao</a></div>
    </div>

    <div class="clear"></div>
</div>
</body>
</html>