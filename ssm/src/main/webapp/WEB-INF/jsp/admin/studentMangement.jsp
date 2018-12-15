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
    <div class="statsRow">
        <div class="wrapper">
            <div class="controlB">
                <!--上传学生名单-->
                <form onsubmit="return false" id="uploadForm" enctype="multipart/form-data">
                    <input type="file" name = "filename" value="" />
                    <input type="submit" value="上传学生名单" id="upload" class="btn dblueB"/>
                </form>
                <div class="clear"></div>
            </div>
        </div>
    </div>

    <div class="statsRow">
        <div class="wrapper">
            <div class="controlB">
                <button class="btn dblueB" id="insBtn">新增</button>
                <button class="btn dredB" id="delBtn">批量删除</button>
                <div class="clear"></div>
            </div>
        </div>
    </div>

    <div class="statsRow" >
        <div class="wrapper" >
            <div class="controlB" style="width:5%;">
                <label>全选<input type = "checkbox" id="check_all" /></label>
                <div class="clear"></div>
            </div>
        </div>
    </div>

    <div class="line"></div>

    <!--该动态数据表已经实现了自动分页，查询，排序的功能-->
    <!-- 学生名单 ==> 动态数据表 -->
    <div class="wrapper">
        <!-- Widgets -->
        <div class="widgets">
            <div class="widget">
                <div class="title">
                    <img src="/static/images/icons/dark/frames.png" alt="" class="titleIcon" />
                    <h6>学生名单</h6>
                </div>
                <table cellpadding="0" cellspacing="0" width="100%" class="display dTable" >
                    <thead>
                    <tr>
                        <td>#</td>
                        <td class="sortCol"><div>学生号<span></span></div></td>
                        <td class="sortCol"><div>学生姓名<span></span></div></td>
                        <td class="sortCol"><div>性别<span></span></div></td>
                        <td class="sortCol"><div>学院<span></span></div></td>
                        <td class="sortCol"><div>专业<span></span></div></td>
                        <td class="sortCol"><div>班级<span></span></div></td>
                        <td class="sortCol"><div>Email<span></span></div></td>
                        <td class="sortCol"><div>操作</div></td>
                    </tr>
                    </thead>
                    <tbody align="center">
                    <c:forEach items="${users}" var="student">
                        <tr>
                            <td>
                                <input type = "checkbox" class = "check_item" />
                            </td>
                            <td>${student.userId}</td>
                            <td>${student.userName}</td>
                            <td>${student.gender}</td>
                            <td>${student.department}</td>
                            <td>${student.major}</td>
                            <td>${student.classes}</td>
                            <td>${student.email}</td>
                            <td><button class="btn update dblueB" >修改</button>
                                <button class="btn del dredB" >删除</button></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


<script type="text/javascript">
    $("#upload").click(function () {

        var formData = new FormData($("#uploadForm")[0]);
        $.ajax({
            url:'${pageContext.request.contextPath}/user/addUsersWithFile',
            type:"POST",
            data:formData,
            contentType: false,
            processData: false,
            cache: false,
            success:function(result){
                alert(result.message);
                if(result.code==100)
                $("#content").load('${pageContext.request.contextPath}/user/selectUsers?roleName=student');
            }
        });
    });
    $("#insBtn").click(function(){
        //alert("insTest");
        $("#content").load('${pageContext.request.contextPath}/user/toAdminInsertPage?roleName=student');
    });

    $(".update").off("click").on("click",function () {
        //alert("updateTest");
        var userId = $(this).parents("tr").find("td:eq(1)").text();
        //alert('/user/toAdminUpdatePage?roleName=student&userId='+userId)
        $("#content").load('${pageContext.request.contextPath}/user/toAdminUpdatePage?roleName=student&userId='+userId);
    });

    //单个删除
    $(".del").off("click").on("click",function(){
        var userId= $(this).parents("tr").find("td:eq(1)").text();
        var userName = $(this).parents("tr").find("td:eq(2)").text();
        if(confirm("确认删除【"+userName+"】吗？")){
            $.ajax({
                url:'${pageContext.request.contextPath}/user/deleteUsersWithJson/'+userId,
                type:"DELETE",
                success:function(result){
                    alert(result.message);
                    $("#content").load('${pageContext.request.contextPath}/user/selectUsers?roleName=student');
                }
            });
        }
    });

    //全选按钮
    $("#check_all").click(function () {
        //prop修改和读取dom原生属性的值
        var flag = $(this).prop("checked");
        $(".check_item").prop("checked",flag);
        //样式会在checkbox前自动加上span
        if(flag == true)
            $(".check_item").parents("span").addClass("checked");
        else
            $(".check_item").parents("span").removeClass("checked");
    });

    //单选按钮全勾选时自动勾选全选按钮
    $(".check_item").off("click").on("click",function () {
        //alert($(this).prop("checked"));
        var flag = $(".check_item:checked").length==$(".check_item").length;
        $("#check_all").prop("checked",flag);
        if(flag==true)
            $("#check_all").parents("span").addClass("checked");
        else
            $("#check_all").parents("span").removeClass("checked");
    });

    //批量删除
    $("#delBtn").click(function(){
        //alert("批量删除测试");
        var userIds = "";
        $.each($(".check_item:checked"),function () {
            userIds += $(this).parents("tr").find("td:eq(1)").text()+"-";
        });
        userIds = userIds.substring(0,userIds.length-1);
        if(confirm("确认删除选中的项目吗？")){
            $.ajax({
                url:'${pageContext.request.contextPath}/user/deleteUsersWithJson/'+userIds,
                type:"DELETE",
                success:function(result){
                    alert(result.message);
                    $("#content").load('${pageContext.request.contextPath}/user/selectUsers?roleName=student');
                }
            });
        }
    });
</script>

</body>

</html>