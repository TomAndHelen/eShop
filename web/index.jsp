<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>电子商城首页</title>
    <%@ include file="/pages/common/head.jsp"%>
  </head>
  <body>
    <h1  >首页</h1>
    <br />

    <c:choose>
      <c:when test="${empty sessionScope.user}">
            <a href="pages/user/register.jsp">注册</a> <br />
            <a href="pages/user/login.jsp">登录</a> <br />
            <a href="pages/user/login.jsp?admin=1">后台管理</a>
      </c:when>
      <c:otherwise>


        <c:if test="${not empty sessionScope.admin}">
          欢迎<span style="color: red">管理员</span><br>
          <a href="goodServlet?action=page">商品管理</a> <br>
          <a href="orderServlet?action=showAllOrders">查看所有订单</a> <br>
        </c:if>

        <c:if test="${empty sessionScope.admin}">
          欢迎<span style="color: red">${sessionScope.user.username}</span><br>
          <a href="goodServlet?action=show">商品浏览界面</a><br>
          <a href="pages/cart/cart.jsp">查看购物车</a> <br>
          <a href="orderServlet?action=showMyOrders&id=${sessionScope.user.id}">查看我的订单</a><br>
        </c:if>
          <a href="userServlet?action=logout">注销</a><br>
      </c:otherwise>
    </c:choose>




  </body>
</html>
