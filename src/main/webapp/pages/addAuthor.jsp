<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 25.01.2021
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>

<form class="row g-3" action="/addAuthor" method="post"
      style="width: 70%; display: block; margin-left: auto; margin-right: auto">
    <h2>Добавьте автора</h2>
    <div class="form-floating mb-3">
        <input type="text" class="form-control" id="floatingInput" placeholder="name" name="name">
        <label for="floatingInput">Name</label>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary" style="display:block; margin-left: auto">Sign in</button>
    </div>
    <c:if test="${requestScope.massage != null}">
        <h3>${requestScope.massage}</h3>
    </c:if>
</form>
</body>
</html>
