<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
<h2>New Dojo</h2>
<form action="/dojos/new" method="post">
    <p>
        <label>Name</label>
        <input name="name" type="text">
    </p>   
    <input type="submit" value="Create"/>
</form>
</body>
</html>