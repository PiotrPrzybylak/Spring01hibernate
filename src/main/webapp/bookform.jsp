<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form method="post" modelAttribute="book">
    <form:input path="title"/>
    <form:input path="description"/>
    <form:select path="rating" items="${ratings}"/>
    <input type="submit" value="Save">
</form:form>

Test
</body>
</html>
