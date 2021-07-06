<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form method="post"
           modelAttribute="student">
    <form:input path="firstName" />
    <form:input path="lastName" />

    <form:password path="password"/>
    <form:textarea path="notes" rows="3"
                   cols="20"/>




    <form:checkboxes items="${skills2}" path="skills"  itemValue="id" itemLabel="name"
                     />
    <input type="submit" value="Save">
</form:form>

Test
</body>
</html>
