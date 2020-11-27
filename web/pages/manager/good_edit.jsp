<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品编辑</title>
    <%@ include file="/pages/common/head.jsp"%>
</head>
<body>
    <h1  >商品编辑</h1>
        <form action="goodServlet" method="post">
    <input type="hidden" name="action" value="${empty param.id ? "add" : "writeBack"}">
    <input type="hidden" name="pageNo" value="${param.pageNo}">
            <table  >
                <tr>
                    <td>名称</td>
                    <td>价格</td>
                    <td>销量</td>
                    <td>库存</td>
                    <td colspan="2">操作</td>
                </tr>
                <tr>
                   <input type="hidden" name="id" value="${requestScope.good.id}">
                    <td><input name="name" type="text" value="${requestScope.good.name}" /></td>
                    <td><input name="price" type="text" value="${requestScope.good.price}"/></td>
                    <td><input name="sales" type="text" value="${requestScope.good.sales}"/></td>
                    <td><input name="stock" type="text" value="${requestScope.good.stock}"/></td>
                    <td><input type="submit" value="提交"/></td>
                </tr>
            </table>
        </form>

</body>
</html>
