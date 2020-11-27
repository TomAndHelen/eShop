<%--
  Created by IntelliJ IDEA.
  User: 84016
  Date: 2020/11/25
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>订单详情</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>

    <h1  >订单${requestScope.orderItems[0].orderId}的详情 </h1>
    <br>
    <table border="1px"  >
        <tr>
            <th>商品名</th>
            <th>数量</th>
            <th>单价</th>
            <th>总价</th>
        </tr>
        <c:forEach items="${requestScope.orderItems}" var="orderItem">
            <tr>
                <td>${orderItem.name}</td>
                <td>${orderItem.count}</td>
                <td>${orderItem.price}</td>
                <td>${orderItem.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>
    <c:if test="${sessionScope.user.id == 1}">
        <a href="orderServlet?action=showAllOrders">返回</a>
    </c:if>
    <c:if test="${sessionScope.user.id != 1}">
        <a href="orderServlet?action=showMyOrders&id=${sessionScope.user.id}">返回</a><br>
    </c:if>

</body>
</html>
