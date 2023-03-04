<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: Tran
  Date: 2022/11/11
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<div style="color: red">
    ${errorMsg}
</div>
<form action="/login">
    <input  type="text" name="username" placeholder="请输入账号"><br>
    <input  type="text" name="password" placeholder="请输入密码"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
