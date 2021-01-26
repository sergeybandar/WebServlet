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
<div style="width: 60%; margin-right: auto; margin-left: auto; display: flex">
    <div style="width: 27%"><img src="${requestScope.book.getPoster()}" class="card-img-top" alt="..."
                                 style="max-width: 220px"></div>
    <div style="width: 72%">
        <h3>${requestScope.book.getName()}</h3>
        <h4>
            <a href="/authors/author?id=${requestScope.book.getAuthor().getId()}"> ${requestScope.book.getAuthor().getName()}</a>
        </h4>
        <c:if test="${sessionScope.isUser}">
            <form action="/books/book" method="post">
                <input type="hidden" name="id" value="${requestScope.book.getId()}">
                <button>Добавить в корзину</button>
            </form>
        </c:if>
    </div>
</div>

</body>
</html>
