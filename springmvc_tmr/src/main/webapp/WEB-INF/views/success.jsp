<%--
  Created by IntelliJ IDEA.
  User: Tran
  Date: 2022/11/14
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<%
    Object username = request.getSession().getAttribute("user");
%>
<h1 style="color: red">欢迎<%=username%>登陆成功！</h1>
<h2>邮箱：${email}</h2>
<h2>手机号：${number}</h2>
</body>
</html>
