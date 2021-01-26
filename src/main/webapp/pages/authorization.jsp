<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 15.01.2021
  Time: 0:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div style="width: 60%; display: block; margin-left: auto; margin-right: auto">
    <form class="row g-3" action="/auth" method="post" style="width: 70%; display: block; margin-left: auto; margin-right: auto">
            <div class="form-floating">
            <input type="text" class="form-control"  placeholder="Login" name="login">
            <label for="floatingPassword">Login</label>
        </div>
        <div class="form-floating">
            <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
            <label for="floatingPassword">Password</label>
        </div>
        <div class="col-12" >
            <button type="submit" class="btn btn-primary" style="display:block; margin-left: auto">Sign in</button>
        </div>
    </form>
    <h2>${requestScope.result}</h2>
</div>
</body>
</html>
