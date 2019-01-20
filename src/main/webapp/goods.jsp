<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Goods List</title>
</head>
<body>
<h1 align="center">商品列表</h1>
<%--这两行代码用于debug的时候查看reque和session的值--%>
<%--request:${requestScope.goods}<br>
session:${sessionScope.goods}--%>
<h2 align="center"><a href="index.jsp">Home Page</a> </h2> <a style="position: center" href="logout.action">注销</a>
<table align="center" style="border: 1px;width: 100%">
    <tr>
        <td>名称</td>
        <td>描述</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.goods != null?requestScope.goods:sessionScope.goods}" var="good">
        <tr>
            <td>${good.name}</td>
            <td>${good.description}</td>
            <td>${good.price}</td>
            <td>
                <c:choose>
                <c:when test="${sessionScope.userType=='normal'}">
                    <a href="buy.action?id=${good.id}">购买</a>
                </c:when>
                <c:otherwise>
                    <a href="down.action">下架</a>  <a href="up.action?${good.id}">上架</a>
                </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
