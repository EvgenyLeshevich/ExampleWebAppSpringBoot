<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>

<div>
    <form action="/logout" method="post">
        <input type="submit" value="Sign Out"/>
    </form>
</div>

<div>
    <form method="post">
        <input type="text" name="text" placeholder="Input to message"/>
        <input type="text" name="tag" placeholder="Tag"/>
        <button type="submit">Add message</button>
    </form>
</div>

<div>List of messages</div>
<form method="post" action="filter">
    <input type="text" name="filter"/>
    <button type="submit">Search</button>
</form>

<c:forEach items="${messages}" var="message">
    <tr>
        <td>${message.id}</td>
        <td>${message.text}</td>
        <td>${message.tag}</td>
        <p></p>
    </tr>
</c:forEach>
</body>
</html>
