
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="/pages/common/head.jsp"%>--%>
<div>
    <c:if test="${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">首页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo-1}">上一页</a>
    </c:if>
    &nbsp;&nbsp;${requestScope.page.pageNo}&nbsp;&nbsp;
    <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo+1}">下一页</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageTotal}">尾页</a>
    </c:if>
    总共${requestScope.page.pageTotal}页，共有${requestScope.page.pageTatalCount}个商品
</div>
