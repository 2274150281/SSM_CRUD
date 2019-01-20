<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<body>
<h1 align="center">商城</h1>
<%--这两行代码用于debug的时候查看request和session中的值--%>
request:${requestScope.user}<br>
session:${sessionScope.user}
<div align="center">
    <c:choose>
        <c:when test="${sessionScope.user != null}">
            您已登录，可以<a href="goods.jsp">查看商品</a>
        </c:when>
        <c:when test="${sessionScope.administrator != null}">
            您已登录，可以<a href="goods.jsp">上架\下架商品</a>
        </c:when>
        <c:otherwise>
            <a href="login.jsp">登录</a>  <a href="adminLogin.jsp">管理员登录</a>
        </c:otherwise>
    </c:choose>
<br><br><br><br><br>
    <a href="test.action">测试</a>
</div>
</body>
</html>
