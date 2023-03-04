<%--
  Created by IntelliJ IDEA.
  User: Tmran
  Date: 2022/11/27
  Time: 0:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addError</title>
</head>
<body>
<script>
  <%--alert("${error.name}或者${error.name}存在,请重新添加!!")--%>
  var msg = confirm("${error.name}已存在,请重新添加!!");
  if (msg) {
    window.location.href = "/department/list";
  }
</script>
<h1 style="text-align: center">宝子,喊你点确定不点！！！！可恶！！！</h1>
<a style="text-decoration:none" href="list">回到主页</a>
</body>
</html>
