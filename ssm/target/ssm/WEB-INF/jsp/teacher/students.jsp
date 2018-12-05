<form action="${pageContext.request.contextPath}/teacher/addAssignment" method="post" id="validate" class="form">
    <div class="formRow">
        <label for="login">作业名称</label>
        <div class="loginInput"><input type="text" name="assignmentName" class="validate[required]" id="login" /></div>
        <div class="clear"></div>
    </div>
    <div class="formRow">
        <label for="login">作业描述或要求</label>
        <div class="loginInput"><input type="text" name="description" class="validate[required]" id="login" /></div>
        <div class="clear"></div>
    </div>
    <div class="formRow">
        <label for="login">提交时间</label>
        <div class="loginInput"><input type="text" name="deadline" class="validate[required]" id="login" /></div>
        <div class="clear"></div>
    </div>
    <div class="formRow">
        <label for="login">作业比例</label>
        <div class="loginInput"><input type="text" name="percentage" class="validate[required]" id="login" /></div>
        <div class="clear"></div>
    </div>
    <div class="loginControl">
        <input type="submit" value="创建" class="dredB logMeIn" />
        <div class="clear"></div>
    </div>
</form>