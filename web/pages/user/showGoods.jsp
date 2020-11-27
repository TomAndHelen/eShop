<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品展示</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1  >商品展示</h1>
    <br />
    欢迎<span style="color: red">${sessionScope.user.username}</span>
    <br />
    <a href="pages/cart/cart.jsp">查看购物车</a>
    <hr>

        <table   border="1px" >
            <tr>
                <th>商品名</th>
                <th>价格</th>
                <th>销量</th>
                <th>库存</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${requestScope.page.items}" var="good">
            <tr>
                <td>${good.name}</td>
                <td>${good.price}</td>
                <td>${good.sales}</td>
                <td>${good.stock}</td>
                <td><a href="cartServlet?action=addItem&id=${good.id}">加入购物车</a></td>
            </tr>
            </c:forEach>
        </table>
        <%@include file="/pages/common/page_nav.jsp"%>
        <a href="index.jsp">返回首页</a>
</body>
</html>
