<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 18.01.2021
  Time: 1:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div style="width: 60%; display: block; margin-left: auto; margin-right: auto">
    <form class="row g-3" action="/info" method="post" style="width: 70%; display: block; margin-left: auto; margin-right: auto">
        <div class="form-floating mb-3">
            <input type="text" class="form-control" id="floatingInput" placeholder="name" name="name" value="${requestScope.name}" readonly>
            <label for="floatingInput">Name</label>
        </div>
        <div class="form-floating">
            <input type="text" class="form-control"  placeholder="Login" name="login" value="${requestScope.login}" readonly>
            <label for="floatingPassword">Login</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" value="${requestScope.password}" readonly>
            <label for="floatingPassword">Password</label>
        </div>
    </form>
</div>
</body>
</html>
