
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            $(".updt").blur(function (){
                var id = $(this).attr("goodId");
                var count = this.value;
                location.href = "/eShop/cartServlet?action=updateCount&id="+id+"&count="+count;
            })
            $("a.del").click(function (){
                return confirm("确定要删除 " + $(this).parent().parent().find("td:first").text()+ " 吗？" );
            })
            $("a.clr").click(function (){
                return confirm("确定要清空购物车吗？" );
            })
        });
    </script>
</head>
<body>
    <h1  >购物车</h1>
    <br>
    <a href="goodServlet?action=show">继续浏览商品</a><br>
    <a href="index.jsp">返回首页</a>
    <hr>
    <c:if test="${empty sessionScope.cart.items}">
            当前购物车为空
    </c:if>

    <c:if test="${not empty sessionScope.cart.items}">
        <table    border="1px">
            <tr>
                <th>商品名</th>
                <th>数量</th>
                <th>单价</th>
                <th>金额</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${sessionScope.cart.items}" var="good">
                <tr>
                    <td>${good.value.name}</td>
                    <td><input class="updt" type="text" goodId="${good.value.id}" value="${good.value.count}"></td>
                    <td>${good.value.price}</td>
                    <td>${good.value.totalPrice}</td>
                    <td><a class="del" href="cartServlet?action=deleteItem&id=${good.value.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <c:if test="${not empty sessionScope.cart.items}">
        购物车共有${sessionScope.cart.totalCount}件商品， 总金额为${sessionScope.cart.totalPrice}元 <br>
        <a class="clr" href="cartServlet?action=clear">清空购物车</a>
        <a href="pages/cart/checkout.jsp">下单</a>
    </c:if>

</body>
</html>
