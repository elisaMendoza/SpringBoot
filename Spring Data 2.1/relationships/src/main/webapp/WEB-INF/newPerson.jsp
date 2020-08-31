<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
</head>
<body>
<form action="/persons/new" method="post">
    <p>
        <label>First Name</label>
        <input name="firstName" type="text">
    </p>
    <p>
        <label>Last Name</label>
        <input name="lastName" type="text">
    </p>   
    <input type="submit" value="Create"/>
</form>
</body>
</html>