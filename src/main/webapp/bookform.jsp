<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form method="post" modelAttribute="book">


    <form:errors path="*" />

    <input type="hidden" name="tajne" value="1234">
    <form:input path="title"/> <form:errors path="title" />
    <form:input path="description"/> <form:errors path="description" />
    <form:input path="pages"/> <form:errors path="pages" />
    <form:select path="rating" items="${ratings}"/> <form:errors path="rating" />
    <form:select path="publisher" itemLabel="name" itemValue="id" items="${publishers}"/>
    <form:errors path="publisher" />
    <input type="submit" value="Save">
</form:form>

Test
</body>
</html>
