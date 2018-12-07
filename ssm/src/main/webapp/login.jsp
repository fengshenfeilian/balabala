<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
	<title>作业管理系统</title>
	<link href="/static/css/main.css" rel="stylesheet" type="text/css" />

	<script type="text/javascript" src="/static/js/jquery.min.js"></script>
	<!--md5加密插件-->
	<script type="text/javascript" src="/static/jquery/jquery.md5.js"></script>
	<script type="text/javascript" src="/static/js/plugins/spinner/ui.spinner.js"></script>
	<script type="text/javascript" src="/static/js/plugins/spinner/jquery.mousewheel.js"></script>
	<script type="text/javascript" src="/static/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="/static/js/plugins/charts/excanvas.min.js"></script>
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
	<!-- Shared on MafiaShare.net  --><!-- Shared on MafiaShare.net  -->
</head>

<body class="nobg loginPage">

<!-- 导航栏 -->
<div class="topNav">
    <div class="wrapper">
        <div class="userNav">		
            <ul>
                <li><a href="#" title=""><img src="/static/images/icons/topnav/mainWebsite.png" alt="" /><span>首页</span></a></li>
                <li><a href="#" title=""><img src="/static/images/icons/topnav/profile.png" alt="" /><span>联系我们</span></a></li>
            </ul> 
        </div>
        <div class="clear"></div>
    </div>
</div>


<!-- Main content wrapper -->
<div class="loginWrapper">
    <div class="loginLogo"><img src="/static/images/loginLogo.png" alt="" /></div>
    <div class="widget">
        <div class="title"><img src="/static/images/icons/dark/files.png" alt="" class="titleIcon" /><h6>登录</h6></div>
       <!-- 表单数据 -->
		<form action="${pageContext.request.contextPath}/user/login" method="post" id="validate" class="form">
            <fieldset>
                <div class="formRow">
                    <label for="login">用户号</label>
                    <div class="loginInput"><input type="text" name="userId"  class="validate[required]" id="login" ></div>
                    <div class="clear"></div>
                </div>
                
                <div class="formRow">
                    <label for="pass">密码</label>
                    <div class="loginInput"><input type="password" name="password" class="validate[required]" id="pass" /></div>
                    <div class="clear"></div>
                </div>
                
                <div class="loginControl">
                    <div class="rememberMe"><input type="checkbox" id="remMe" name="remMe" /><label for="remMe">记住我</label></div>
                    <input type="submit" value="登录" class="dredB logMeIn" />
                    <div class="clear"></div>
                </div>
            </fieldset>
        </form>
    </div>
</div>


<!-- Footer line -->
<div id="footer">
    <div class="wrapper">All right reserved by Marco</div>
</div>
<script type="text/javascript">
	$("#validate").validate();
	//前端密码加密
	$("#validate").submit(function(){
	    //alert("test");
		var pwd = $("#pass").val();
		if(pwd != ""){
            pwd = $.md5(pwd);
            $("#pass").val(pwd);
		}
	});
</script>

</body>
</html>