<%--
  Created by IntelliJ IDEA.
  User: Tmran
  Date: 2023-02-28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>学生成绩单</title>
</head>
<body>
<%--<div style="color: red">
    ${errorMsg}
</div>--%>
<%--<form action="/login">--%>
<%--    姓名：<input  type="text" name="name"><br>--%>
<%--    学号：<input  type="text" name="id"><br>--%>
<%--    班级：<input type="email" name="classroom"><br>--%>
<%--</form>--%>
<div class="box">
    <!--高级查询--->
    <form action="/student/select" method="post">
        <a href="/student/input" style="margin: 10px">
            <span>添加</span>
        </a>
    </form>
    <!--编写内容-->
    <div>
        <table>
            <tr>
                <th>姓名</th>
                <th>学号</th>
                <th>班级</th>
                <th>成绩</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${allStudents}" var="entity" varStatus="vs">
                <tr>
                    <td>${entity.name}</td>
                    <td>${entity.id}</td>
                    <td>${entity.classroom}</td>
                    <td>${entity.score}</td>
                    <td>
                        <a href="/student/input?id=${entity.id}">
                            <span></span> 编辑
                        </a>
                        <a href="/student/delete?id=${entity.id}">
                            <span></span> 删除
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
