<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <%@ include file="/pages/common/head.jsp"%>
    <style>
        input{
            width: 120px;
            height: 32px;
        }
    </style>
</head>
<body>
    <h1  >登录</h1> <br>
    <form action="userServlet" method="post">
        <span style="color: red">${requestScope.msg}</span>
        <input type="hidden" name="action" value="${empty param.admin ? "login" : "mlogin" }"> <br>
        <table  >
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
            </tr>
            <tr>
                <td><a href="#">返回首页</a></td>
            </tr>
        </table>
    </form>
</body>
</html>
