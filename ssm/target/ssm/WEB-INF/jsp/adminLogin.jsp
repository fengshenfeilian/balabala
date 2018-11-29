<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">


    <title>Admin Login</title>

    <!-- Bootstrap core CSS -->
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script src="/static/jquery/jquery-3.3.1.min.js"></script>

    <script src="/static/bootstrap/js/bootstrap.min.js"></script>

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">



</head>

<body>

<div class="container">

    <div class = "row">
        <div class = "col-md-4 col-md-offset-4">
            <form class="form-signin" action = "/login" method="post">
                <h2 class="form-signin-heading">管理员登陆</h2>
                <label for="inputUsername" class="sr-only">请输入用户名</label>
                <input type="username" id="inputUsername" class="form-control" placeholder="请输入管理员名" required autofocus>
                <label for="inputPassword" class="sr-only">请输入密码</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="请输入密码" required>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
        </div>
    </div>


</div> <!-- /container -->



</body>
</html>

