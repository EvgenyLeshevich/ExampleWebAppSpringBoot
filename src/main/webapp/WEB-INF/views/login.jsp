<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
Login page
<form action="/login" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
    <div><input type="submit" value="Sign In"/></div>
</form>
<a href="/registration">Registration</a>
</body>
</html>
