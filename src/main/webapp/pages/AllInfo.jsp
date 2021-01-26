<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Xiaomi
  Date: 19.01.2021
  Time: 0:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_header.jsp"/>
<div style="width: 60%; margin-left: auto; margin-right: auto">
    <c:if test="${requestScope.users == null}">
        <h3>No registered users</h3>
    </c:if>
    <c:if test="${requestScope.users != null}">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Login</th>
                <th scope="col">Name</th>
                <th scope="col">Password</th>
                <th scope="col">Role</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.users}" var="user">
                <tr>
                    <th scope="row">${user.getUserId()}</th>
                    <td>${user.getLogin()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getPassword()}</td>
                    <td>${user.getRole()}</td>

                    <c:if test="${sessionScope.isSuperAdmin}">
                        <td>
                            <form action="/role" method="post">
                                <input type="hidden" name="login" value="${user.getLogin()}">
                                <button>Add</button>
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
</body>
</html>
