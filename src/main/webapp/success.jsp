<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

Dodano:
${student}


<c:forEach items="${languages}" var="lang">
    ${lang}<br>
</c:forEach>

<form:form method="post"
           modelAttribute="student">
    <form:input path="firstName" />
    <form:input path="lastName" />
    <input type="submit" value="Save">
</form:form>




Test
</body>
</html>
