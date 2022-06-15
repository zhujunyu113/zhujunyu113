<%--
  Created by IntelliJ IDEA.
  User: 29170
  Date: 2022/4/20
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
  <head>
    <title>登录</title>
  </head>
  <body>
  <form method="post" action="<%=application.getContextPath()%>/hotel">
    <h4>用户名:</h4>
    <br>
    <input type="text" name="username">
    <h4>密码:</h4>
    <br>
    <input type="password" name="password">
    <br>
    <input type="checkbox" name="autologin" value="1">下次自动登录
    <br>
    <input type="submit" value="登录">


  </form>

  </body>
</html>
