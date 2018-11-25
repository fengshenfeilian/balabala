<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


    <title>Admin </title>

    <!-- Bootstrap core CSS -->
    <link href="/static/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <script src="/static/jquery/jquery-3.3.1.min.js"></script>

    <script src="/static/bootstrap/js/bootstrap.min.js"></script>

    <!-- Custom styles for this template -->
    <link href="signin.css" rel="stylesheet">



</head>

<body>
<c:forEach items="${pageInfo.list}" var="user">
    <p>${user.userId}</p>
    <p>${user.roleId}</p>
    <p>${user.password}</p>
    <p>${user.userName}</p>
    <p>${user.role.roleId}</p>
    <p>${user.role.name}</p>
    <p>${user.role.description}</p>
</c:forEach>
</body>
</html>


