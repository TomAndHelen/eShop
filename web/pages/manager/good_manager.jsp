<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品管理</title>
    <%@ include file="/pages/common/head.jsp"%>
    <script type="text/javascript" >
        $(function (){
            $("a.del").click(function (){
                return confirm("确定要删除编号为 " + $(this).parent().parent().find("td:first").text()+ " 的商品吗？" );
            })
        })
    </script>
</head>
<body>
    <h1  >商品管理</h1>
    <br>
    <table   border="2px">
        <tr >
            <th>编号</th>
            <th>商品名</th>
            <th>价格</th>
            <th>销量</th>
            <th>库存</th>
            <th colspan="2">功能</th>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="good">
            <tr>
                <td>${good.id}</td>
                <td>${good.name}</td>
                <td>${good.price}</td>
                <td>${good.sales}</td>
                <td>${good.stock}</td>
                <td><a href="goodServlet?action=change&id=${good.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
                <td><a href="goodServlet?action=delete&id=${good.id}&pageNo=${requestScope.page.pageNo}" class="del">删除</a></td>
            </tr>
        </c:forEach>
    </table>
    <%@include file="/pages/common/page_nav.jsp"%>
    <a href="pages/manager/good_edit.jsp">添加商品</a>
    <a href="index.jsp">返回首页</a>
</body>
</html>
