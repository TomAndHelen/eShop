<%@ page import="java.math.BigDecimal" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1  >个人订单</h1> <br>
    欢迎<span style="color: red">${sessionScope.user.username}</span><br>
    <c:if test="${empty requestScope.orders}">
        你暂时还没有下过单 <br>
    </c:if>
    <c:if test="${not empty requestScope.orders}">
    <table   border="1px">
        <tr>
            <th>订单号</th>
            <th>下单时间</th>
            <th>订单总价</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${requestScope.orders}" var="order">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.createTime}</td>
                <td>${order.price}</td>
                <td><a href="orderServlet?action=showOrderDetails&orderId=${order.orderId}">查看详情</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
    <a href="index.jsp">返回首页</a>
</body>
</html>
