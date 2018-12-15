<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
    <link href="/static/css/main.css" rel="stylesheet" type="text/css" />


    <script type="text/javascript" src="/static/js/jquery.min.js"></script>
    <!--md5加密插件-->
    <script type="text/javascript" src="/static/jquery/jquery.md5.js"></script>
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
        <li class="dash"><a href="/teacher/index" title="" class="active"><span>课程管理</span></a></li>
    </ul>
</div>

<!-- 右侧区域 -->
<div id="rightSide">
    <!-- 顶部导航栏 -->
    <div class="topNav">
        <div class="wrapper">
            <div class="welcome"><a href="#" title=""><img src="/static/images/userPic.png" alt="" /></a><span>欢迎【<c:out value="${user.userName}" />】老师使用本系统</span></div>

            <div class="userNav">
                <ul>
                    <li><a href="javascript:void(0);" title="" id="userConfig"><img src="/static/images/icons/topnav/profile.png" alt="" /><span>账户</span></a></li>
                    <%--<li><a href="#" title=""><img src="/static/images/icons/topnav/settings.png" alt="" /><span>设置</span></a></li>--%>
                    <li><a href="${pageContext.request.contextPath}/user/logout" title=""><img src="/static/images/icons/topnav/logout.png" alt="" /><span>注销</span></a></li>
                </ul>
            </div>

            <div class="clear"></div>
        </div>
    </div>


<div class="wrapper">
        <div class="widget" style="width:80%;">
            <div class="title"><h6>教师信息修改</h6></div>
            <!-- 表单数据 -->
            <form class="form" onsubmit="return false" id="tForm">
                <fieldset>
                    <div class="formRow">
                        <label style="width:10%">工号</label>
                        <input type="text" name="userId" id="userId" disabled = "disabled" value="${sessionScope.currentUser.userId}" style="width:60%"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label style="width:10%">姓名</label>
                        <input type="text" name="userName"  disabled = "disabled" value="${sessionScope.currentUser.userName}" id="userName" style="width:60%;"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label style="width:10%">性别</label>
                        <input type="text" name="gender"  disabled = "disabled" value="${sessionScope.currentUser.gender}" id="gender" style="width:60%;"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label style="width:10%">学院</label>
                        <input type="text" name="department"  disabled = "disabled" value="${sessionScope.currentUser.department}" id="department" style="width:60%;"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label style="width:10%">Email</label>
                        <input type="text" name="email"  value="${sessionScope.currentUser.email}" id="email" style="width:60%;"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formSubmit">
                        <button class="btn dredB" id = "tUpdate">设置</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>



<div class="wrapper">
        <div class="widget" style="width:80%;">
            <div class="title"><h6>密码修改</h6></div>
            <!-- 表单数据 -->
            <form class="form" onsubmit="return false" id="pwdForm">
                <fieldset>
                    <div class="formRow">
                        <label style="width:10%">当前密码</label>
                        <input type="password" name="old_password"  id="old_password"  style="width:60%"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label style="width:10%">新密码</label>
                        <input type="password" name="password"  id="password"  style="width:60%"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label style="width:10%">新密码确认</label>
                        <input type="password" name="confirm_password"  id="confirm_password"  style="width:60%"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formSubmit">
                        <button class="btn dredB" id = "pwdUpdate">确定</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>





<script type="text/javascript">

    jQuery.validator.addMethod("checkPWD", function(value, element) {
        var tel = /^[a-zA-Z0-9_-]{6,18}$/;
        return this.optional(element) || (tel.test(value));
    }, "密码格式错误，应为6到18位的字母数字组合");
    jQuery.validator.addMethod("checkEmail", function(value, element) {
        var tel = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
        return this.optional(element) || (tel.test(value));
    }, "Email格式错误");


    var tvalidator = $("#tForm").validate({
        rules:{
            email:{
                checkEmail:true,
            }
        },
        //提交表单后，（第一个）未通过验证的表单获得焦点
        focusInvalid:true,
        //当未通过验证的元素获得焦点时，移除错误提示
        focusCleanup:true,
    });
    var pwdvalidator = $("#pwdForm").validate({
        rules:{
            old_password:{
                required:true,
            },
            password:{
                required:true,
                checkPWD:true,
            },
            confirm_password:{
                required:true,
                equalTo:"#password",
            }
        },
        messages:{
            old_password:{
                required:"请输入原先的密码",
            },
            password:{
                required:"请输入新密码",
            },
            confirm_password:{
                required:"请再次输入新密码",
                equalTo:"两次输入不同",
            }
        },
        //提交表单后，（第一个）未通过验证的表单获得焦点
        focusInvalid:true,
    });


    $("#tUpdate").click(function () {
        var datas = $("#tForm").serialize();
        //alert(datas);
        if(tvalidator.form()){
            $.ajax({
                url:"${pageContext.request.contextPath}/user/updateUsersWithJson/"+'${sessionScope.currentUser.userId}',
                data:datas + "&_method=PUT",
                type:"POST",
                success:function(result){
                    alert(result.message);

                }
            });
        }

    });

    $("#pwdUpdate").click(function () {
        //alert("password");
        var userId = '${sessionScope.currentUser.userId}';
        var enOldPWD = $.md5($("#old_password").val());
        var enNewPWD = $.md5($("#password").val());
        if(pwdvalidator.form()){
            $.ajax({
                url:"${pageContext.request.contextPath}/user/updatePasswordWithJson",
                data:{userId:userId,old_password:enOldPWD,password:enNewPWD},
                type:"POST",
                success:function(result){
                    alert(result.message);
                    //修改成功跳回登陆页
                    if(result.code==100)
                    window.location.href = "${pageContext.request.contextPath}/login.jsp";
                }
            });
        }
    });

</script>
</div>
</body>

</html>