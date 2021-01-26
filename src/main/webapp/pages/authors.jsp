<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 22.01.2021
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<h2>Authors</h2>
<ul>
    <c:forEach items="${requestScope.authors}" var="author">
        <li><a href="/authors/author?id=${author.getId()}">${author.getName()}</a></li>
    </c:forEach>
</ul>
</body>
</html>
