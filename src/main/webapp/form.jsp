<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>


<form:form method="post" modelAttribute="person">

    <form:password path="password" />
<form:input path="email" />
    <input type="submit" value="Save">
</form:form>

Test
</body>
</html>
