<%--
  Created by IntelliJ IDEA.
  User: may
  Date: 18-7-10
  Time: 下午4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<h1>用户登录界面</h1>
<hr>
<form name="loginForm" method="post" action="/servlet/LoginServlet">
    <tr>
        <td>用户名:</td>
        <td><input name="username" type="text" value=""/></td>
    </tr>
    <tr>
        <td>密码:</td>
        <td><input name="password" type="password" value=""/></td>
    </tr>
    <tr>
        <td><input name="submit" type="submit" value="提交"></td>
    </tr>
</form>
</body>
</html>
