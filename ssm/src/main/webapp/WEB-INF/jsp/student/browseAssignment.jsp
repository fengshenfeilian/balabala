<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    <div class="logo"><a href="/student/home"><img src="/static/images/logo.png" alt="" /></a></div>

    <div class="sidebarSep mt0"></div>

    <!-- 搜索框 -->
    <form action="" class="sidebarSearch">
        <input type="text" name="search" placeholder="search..." id="ac" />
        <input type="submit" value="" />
    </form>

    <div class="sidebarSep"></div>

    <!-- 左侧导航栏 -->
    <ul id="menu" class="nav">
        <li class="dash"><a href="/student/home" title=""><span>我的主页</span></a></li>
        <li class="tables"><a href="/student/course" title="" ><span>课程管理</span></a></li>
        <li class="tables"><a href="#" title="" class="active exp"><span>作业管理</span><strong>2</strong></a>
            <ul class="sub">
                <li class="this"><a href="/student/assignment" title="">查看作业</a></li>
                <%--<li><a href="/student/uploadAssignment" title="">上传作业</a></li>--%>
            </ul>
        </li>
        <li class="tables"><a href="#" title="" class="exp"><span>小组管理</span><strong>2</strong></a>
            <ul class="sub">
                <li class="this"><a href="/student/groupList" title="" >我的小组</a></li>
                <li><a href="/student/course" title="">创建小组</a></li>
            </ul>
        </li>
    </ul>
</div>

<!-- 右侧区域 -->
<div id="rightSide">
    <!-- 顶部导航栏 -->
    <div class="topNav">
        <div class="wrapper">
            <div class="welcome"><a href="#" title=""><img src="/static/images/userPic.png" alt="" /></a><span>欢迎<strong>【<c:out value="${sessionScope.currentUser.userName}"/>】同学</strong>使用本系统</span></div>

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

    <% String groupId = request.getParameter("groupId");%>
    <%-- 待交作业列表--%>
    <div class="wrapper">
        <!-- Widgets -->
        <div class="widgets">
            <div class="widget">
                <div class="title">
                    <img src="/static/images/icons/dark/frames.png" alt="" class="titleIcon" />
                    <h6>即将过期</h6>
                </div>
                <table cellpadding="0" cellspacing="0" width="100%" class="display dTable" >
                    <thead>
                    <tr>
                        <td class="sortCol"><div>作业ID<span></span></div></td>
                        <td class="sortCol"><div>作业名称<span></span></div></td>
                        <td class="sortCol"><div>基本描述<span></span></div></td>
                        <td class="sortCol"><div>截止时间<span></span></div></td>
                        <td class="sortCol"><div>发布时间<span></span></div></td>
                        <td class="sortCol"><div>分值比例<span></span></div></td>
                        <td class="sortCol"><div>选项<span></span></div></td>
                    </tr>
                    </thead>
                    <tbody align="center">
                    <c:forEach items="${comingToEndAssignments}" var="comingToEndAssignments">
                        <tr>
                            <td><div style="color: darkred">${comingToEndAssignments.assignmentId}</div></td>
                            <td><div style="color: darkred">${comingToEndAssignments.title}</div></td>
                            <td><div style="color: darkred">${comingToEndAssignments.body}</div></td>
                            <td><div style="color: darkred">${comingToEndAssignments.deadline}</div></td>
                            <td><div style="color: darkred">${comingToEndAssignments.releaseTime}</div></td>
                            <td><div style="color: darkred">${comingToEndAssignments.percent}%</td>
                            <td>
                                <a href="/student/uploadAssignment?assignmentId=${comingToEndAssignments.assignmentId}&groupId=<%=groupId%>">
                                    <button class="blueB">上传作业</button>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- 作业要求 ==> 动态数据表 -->
    <div class="wrapper">
        <!-- Widgets -->
        <div class="widgets">
            <div class="widget">
                <div class="title">
                    <img src="/static/images/icons/dark/frames.png" alt="" class="titleIcon" />
                    <h6>已布置作业</h6>
                </div>
                <table cellpadding="0" cellspacing="0" width="100%" class="display dTable assignmentTable">
                    <thead>
                    <tr>
                        <td class="sortCol"><div>作业ID<span></span></div></td>
                        <td class="sortCol"><div>作业名称<span></span></div></td>
                        <td class="sortCol"><div>基本描述<span></span></div></td>
                        <td class="sortCol"><div>截止时间<span></span></div></td>
                        <td class="sortCol"><div>发布时间<span></span></div></td>
                        <td class="sortCol"><div>分值比例<span></span></div></td>
                        <td class="sortCol"><div>选项<span></span></div></td>
                    </tr>
                    </thead>
                    <tbody align="center">
                    <c:forEach items="${assignments}" var="assignment" varStatus="loop">
                        <tr>
                            <td>${assignment.assignmentId}</td>
                            <td>${assignment.title}</td>
                            <td>${assignment.body}</td>
                            <td>${assignment.deadline}</td>
                            <td>${assignment.releaseTime}</td>
                            <td>${assignment.percent}%</td>
                            <td>
                                <c:choose>
                                    <c:when test="${notOverTime[loop.count-1]}"><%--当前时间未超过提交截止时间--%>
                                        <a href="/student/uploadAssignment?assignmentId=${assignment.assignmentId}&groupId=<%=groupId%>">
                                            <button class="blueB">上传作业</button>
                                        </a>
                                    </c:when>

                                    <c:otherwise>
                                        已截止
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <%--动态数据表--%>
    <div class="wrapper">
        <div class="widget">
            <div class="title"><img src="/static/images/icons/dark/frames.png" alt="" class="titleIcon" />
                <h6>已提交作业列表</h6></div>
            <table cellpadding="0" cellspacing="0" width="100%" class="display dTable" id="res1">
                <thead>
                <tr>
                    <td class="sortCol"><div>作业ID<span></span></div></td>
                    <td class="sortCol"><div>提交作业标题<span></span></div></td>
                    <td class="sortCol"><div>作业路径<span></span></div></td>
                    <td class="sortCol"><div>小组ID<span></span></div></td>
                    <td class="sortCol"><div>提交时间<span></span></div></td>
                    <td class="sortCol"><div>分数<span></span></div></td>
                </tr>
                </thead>
                <tbody align="center">
                <c:forEach items="${group_assignment}" var="group_assignment">
                    <tr>
                        <td>${group_assignment.assignmentId}</td>
                        <td>${group_assignment.title}</td>
                        <td>${group_assignment.body}</td>
                        <td>${group_assignment.groupId}</td>
                        <td>${group_assignment.submissionTime}</td>
                        <td>${group_assignment.score}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


    <!-- Footer line -->
    <div id="footer">
        <div class="wrapper">All rights reserved by <a href="http://hashmap.me">Marco Hao</a></div>
    </div>
    <script type="text/javascript">


    </script>
    <div class="clear"></div>
</div>
</body>
</html>