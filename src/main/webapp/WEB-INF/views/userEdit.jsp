<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User edit</title>
</head>
<body>
User editor
<form method="post" action="/user">
    <input type="text" name="username" value="${user.username}">
    <c:forEach items="${roles}" var="role">
        <div>
            <label><input type="checkbox" name="${role}" <%= ("${user.roles}".equals("${role}") ? "checked" : "") %></label>
        </div>
    </c:forEach>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
    <button type="submit">Save</button>
</form>
</body>
</html>
