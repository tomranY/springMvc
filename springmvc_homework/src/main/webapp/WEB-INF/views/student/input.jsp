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
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>增改操作</title>
</head>
<body>
<div>
  <div>
      <div>
        <form action="/student/saveOrUpdate" method="post">
          <input type="hidden" value="${student.id}" name="id">
          <div style="margin-top: 10px;">
            <label for="name">姓名：</label>
            <div>
              <input type="text" id="name" name="name" value="${student.name}"
                     placeholder="请输入姓名">
            </div>
          </div>
          <div style="margin-top: 10px;">
            <label for="classroom">班级：</label>
            <div class="col-sm-4">
              <input type="text" id="classroom" name="classroom" value="${student.classroom}"
                     placeholder="请输入班级">
            </div>
          </div>
          <div>
            <label for="score">分数：</label>
            <div class="col-sm-4">
              <input type="text" id="score" name="score" value="${student.score}"
                     placeholder="请输入分数">
            </div>
          </div>

          <div>
            <div class="col-sm-offset-1 col-sm-6">
              <button id="submitBtn" type="submit">保存</button>
              <button type="reset">重置</button>
            </div>
          </div>

        </form>

      </div>
  </div>
</div>
</body>
</html>
