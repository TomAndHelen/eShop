<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下单</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1  >确认订单</h1>
    <table   border="1px">
        <tr>
            <th>商品名</th>
            <th>数量</th>
            <th>单价</th>
            <th>总价</th>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="good">
            <tr>
                <td>${good.value.name}</td>
                <td>${good.value.count}</td>
                <td>${good.value.price}</td>
                <td>${good.value.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="orderServlet?action=createOrder">确认下单</a> <br>
    <a href="pages/cart/cart.jsp">返回购物车</a>
</body>
</html>
