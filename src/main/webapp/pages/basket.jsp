<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 25.01.2021
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div class="row row-cols-1 row-cols-md-4 g-4" style="width: 60%; margin-left: auto; margin-right: auto">
    <c:forEach items="${sessionScope.basket.all}" var="book">
        <div class="col">
            <div class="card h-100">
                <img src="${book.getPoster()}" class="card-img-top" alt="..." style="max-width: 280px">
                <div class="card-body">
                    <p class="card-title"><a href="/authors/author?id=${book.getAuthor().getId()}">${book.getAuthor().getName()}</a></p>
                    <h4 class="card-text"><a href="/books/book?id=${book.getId()}">${book.getName()}</a></h4>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>
