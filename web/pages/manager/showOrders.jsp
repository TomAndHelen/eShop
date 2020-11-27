<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有订单</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1  >所有订单</h1>
    <br>
    <c:if test="${ empty requestScope.orders}">
        暂时没有人下过单 <br>
    </c:if>
    <c:if test="${not empty requestScope.orders}">
        <table   border="1px">
            <tr>
                <th>订单号</th>
                <th>下单时间</th>
                <th>金额</th>
                <th>用户id</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.orders}" var="order">
                <tr>
                    <td>${order.orderId}</td>
                    <td>${order.createTime}</td>
                    <td>${order.price}</td>
                    <td>${order.userId}</td>
                    <td><a href="orderServlet?action=showOrderDetails&orderId=${order.orderId}">查看详情</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <a href="#">返回首页</a>

</body>
</html>
