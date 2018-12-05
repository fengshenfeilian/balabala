<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;" />
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

<!-- 右侧区域 -->

<!-- 选项区域 -->
<c:if test="${roleName=='student'}">
    <div class="wrapper">
        <div class="widget" style="width:80%;">
            <div class="title"><h6>新增</h6></div>
            <!-- 表单数据 -->
            <form class="form" onsubmit="return false" id="sForm">
                <fieldset>
                    <div class="formRow">
                        <label>学号</label>
                        <br>
                        <input type="text" name="userId" class="validate[required]" id="userId" disabled = "disabled" value="${updateUser.userId}" style="width:60%"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label>姓名</label>
                        <br>
                        <input type="text" name="userName" class="validate[required]" value="${updateUser.userName}" id="userName" style="width:60%;"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label >性别</label>
                        <br>
                        <c:if test="${updateUser.gender=='男'}">
                            <label><input type="radio" name="gender" class="validate[required]" value="男" checked/>男</label>
                            <label><input type="radio" name="gender" class="validate[required]"value="女"/>女</label>
                        </c:if>
                        <c:if test="${updateUser.gender=='女'}">
                            <label><input type="radio" name="gender" class="validate[required]"value="男" />男</label>
                            <label><input type="radio" name="gender" class="validate[required]" value="女" checked/>女</label>
                        </c:if>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label>学院</label>
                        <br>
                        <input type="text" name="department" class="validate[required]" value="${updateUser.department}" id="department" style="width:60%;"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label>专业</label>
                        <br>
                        <input type="text" name="major" class="validate[required]" value="${updateUser.major}" id="major" style="width:60%;"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label>班级</label>
                        <br>
                        <input type="text" name="classes" class="validate[required]" value="${updateUser.classes}" id="classes" style="width:60%;"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formRow">
                        <label>Email</label>
                        <br>
                        <input type="text" name="email" class="validate[required]" value="${updateUser.email}" id="email" style="width:60%;"/>
                        <div class="clear"></div>
                    </div>

                    <div class="formSubmit">
                        <button class="btn dredB" id = "sUpdate">确认</button>
                        <button class="btn dblueB" id = "sReturn">返回</button>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
</c:if>





<script type="text/javascript">
    $("#sUpdate").click(function () {
        var datas = $("#sForm").serialize();
        //不加单引号会被识别为8进制字符
        datas = datas + "&" + "roleId=" + '${updateUser.roleId}';
        //alert(datas);
        $.ajax({
            url:"${pageContext.request.contextPath}/user/updateUsersWithJson/"+'${updateUser.userId}',
            data:datas + "&_method=PUT",
            type:"POST",
            success:function(result){
                alert(result.message);
                $("#content").load('${pageContext.request.contextPath}/user/selectUsers?roleName=student');
            }
        });

    });
    $("#sReturn").click(function(){
        //alert("test");
        $("#content").load('${pageContext.request.contextPath}/user/selectUsers?roleName=student');
    });
</script>

</body>

</html>