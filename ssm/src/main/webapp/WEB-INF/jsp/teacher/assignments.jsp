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

    <!-- 标题区 -->
    <div class="titleArea">
        <div class="wrapper">
            <div class="pageTitle">
                <h5>作业信息</h5>
                <p>作业要求:${assignment.title}</p>
                <p>基本描述:${assignment.body}</p>
                <p>作业发布时间:${assignment.releaseTime}</p>
                <p>作业提交时间:${assignment.deadline}</p>
                <p>作业占比:${assignment.percent}</p>
                <c:if test="${course.isEnd == 0}">
                    <form action="${pageContext.request.contextPath}/teacher/modifyPercent" method="post" id="validate" class="form">
                        <div class="formRow">
                            <label style="width:10%">修改比例</label>
                            <div><input type="text" name="newPercent" style="width:50%"required /></div>
                            <div class="clear"></div>
                        </div>
                        <div class="loginControl">
                            <input type="submit" value="确认修改" class="dredB logMeIn" />
                            <div class="clear"></div>
                        </div>
                    </form>
                </c:if>
                <!-- 选项区域
                <div class="statsRow">
                    <div class="wrapper">
                        <div class="controlB">
                            <!--上传学生名单
                                            <form action="${pageContext.request.contextPath}/user/importUserList" method="get" id="validate" class="form">

                            <form action="${pageContext.request.contextPath}/teacher/addStudentByFile" method="post" enctype="multipart/form-data">
                                <input type="file" name="filename"  value="" />
                                <input type="submit" name=""  value="上传学生名单" />
                            </form>

                            <div class="clear"></div>
                        </div>
                    </div>
                </div> -->
            </div>
            <div class="clear"></div>
        </div>
    </div>


    <div class="line"></div>

    <!-- 学生名单 ==> 动态数据表 -->
    <div class="wrapper">
        <!-- Widgets -->
        <div class="widgets">
            <div class="widget">
                    <div class="title">
                        <img src="/static/images/icons/dark/frames.png" alt="" class="titleIcon" />
                        <h6>提交作业列表</h6>
                    </div>
                    <table cellpadding="0" cellspacing="0" width="100%" class="display dTable" >
                        <thead>
                        <tr>
                            <td class="sortCol"><div>提交时间<span></span></div></td>
                            <td class="sortCol"><div>小组名称<span></span></div></td>
                            <td class="sortCol"><div>作业名称<span></span></div></td>
                            <td class="sortCol"><div>提交人姓名<span></span></div></td>
                            <td class="sortCol"><div>成绩<span></span></div></td>
                            <td class="sortCol"><div>操作<span></span></div></td>
                        </tr>
                        </thead>
                        <tbody align="center">
                        <c:forEach items="${group_assignments}" var="group_assignment">
                            <tr>
                                <td>${group_assignment.submissionTime}</td>
                                <td>${group_assignment.groupName}</td>
                                <td>${group_assignment.title}</td>
                                <td>${group_assignment.studentName}</td>
                                <td>${group_assignment.score}</td>
                                <td><a href="/teacher/goScore?assignmentId=${group_assignment.assignmentId}&groupId=${group_assignment.groupId}">查看/评分</a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
            </div>
        </div>
    </div>

    <!-- Footer line -->
    <div id="footer">
        <div class="wrapper">All rights reserved by <a href="http://hashmap.me">Marco Hao</a></div>
    </div>

    <div class="clear"></div>
</div>
</body>
</html>