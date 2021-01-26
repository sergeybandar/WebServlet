<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 22.01.2021
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div style="width: 60%; margin-right: auto; margin-left: auto">
    <h3>Книги данного автора:</h3>
    <div style="display: flex; flex-direction: column">
        <c:forEach items="${requestScope.author.getAllBook()}" var="book">
            <div style="display: flex; margin-top: 30px">
                <div style="width: 27%"><img src="${book.getPoster()}" class="card-img-top" alt="..."
                                             style="max-width: 220px"></div>
                <div style="width: 72%">
                    <h3><a href="/books/book?id=${book.getId()}"> ${book.getName()}</a></h3>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
