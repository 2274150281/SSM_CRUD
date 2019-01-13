<%@ page import="java.util.List" %>
<%@ page import="beans.Good" %>
<%@ page import="org.springframework.beans.factory.annotation.Autowired" %>
<%@ page import="DAO.GoodMapper" %><%--
  Created by IntelliJ IDEA.
  User: Scholar
  Date: 2019/1/9
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Goods List</title>
</head>
<body>
<h1 align="center">商品列表</h1>
<table align="center" style="border: 1px;width: 100%">
    <tr>
        <td>名称</td>
        <td>描述</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.goods}" var="good">
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
