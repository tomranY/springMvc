<%--
  Created by IntelliJ IDEA.
  User: Tran
  Date: 2022/11/14
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form action="/fileUpload" method="POST" enctype="multipart/form-data">
    文件:<input type="file" name="file"><br>
    <input type="reset" value="清空"><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
