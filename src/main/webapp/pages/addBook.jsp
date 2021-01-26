<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 25.01.2021
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<form class="row g-3" action="/addBook" method="post"
      style="width: 70%; display: block; margin-left: auto; margin-right: auto">
    <h2>Добавьте книгу</h2>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" id="floatingInput" placeholder="name" name="name">
        <label for="floatingInput">Name</label>
    </div>
    <div class="form-floating">
        <input type="text" class="form-control" placeholder="Poster" name="poster">
        <label for="floatingPassword">Poster-url</label>
    </div>
    <div class="form-floating">
        <input type="text" class="form-control" id="floatingPassword" placeholder="Author name" name="author">
        <label for="floatingPassword">Author name</label>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary" style="display:block; margin-left: auto">Add</button>
    </div>
    <c:if test="${requestScope.massage != null}">
        <h3>${requestScope.massage}</h3>
        <c:if test="${requestScope.book != null}">
            <div style="width: 60%; margin-right: auto; margin-left: auto; display: flex">
                <div style="width: 27%"><img src="${requestScope.book.getPoster()}" class="card-img-top" alt="..."
                                             style="max-width: 220px"></div>
                <div style="width: 72%">
                    <h3>${requestScope.book.getName()}</h3>
                    <h4>
                        <a href="/authors/author?id=${requestScope.book.getAuthor().getId()}"> ${requestScope.book.getAuthor().getName()}</a>
                    </h4>
                </div>
            </div>
        </c:if>
    </c:if>
</form>
</body>
</html>
