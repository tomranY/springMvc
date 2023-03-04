<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: Tran
  Date: 2022/11/11
  Time: 11:44
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
    账号：<input  type="text" name="username" placeholder="请输入账号"><br>
    密码：<input  type="text" name="password" placeholder="请输入密码"><br>
    邮箱：<input type="email" name="email" placeholder="请输入邮箱"><br>
    手机：<input type="tel" name="number" placeholder="请输入手机号"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
