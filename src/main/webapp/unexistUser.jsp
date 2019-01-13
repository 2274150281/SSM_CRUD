<%--
  Created by IntelliJ IDEA.
  User: Scholar
  Date: 2019/1/13
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Unexist</title>
</head>
<body>
<h1 align="center">Unexist
    <c:choose>
        <c:when test="${sessionScope.userType == 'normal'}">User</c:when>
        <c:otherwise>Administrator</c:otherwise>
    </c:choose> Unexist</title></h1>
click <a href="index.jsp">here</a> to the main page
</body>
</html>
