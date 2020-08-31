<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
<form action="/ninjas/new" method="post">
    <p>
        <label>Dojo</label>
        <select name="dojos">
        <c:forEach var="dojos" items="${dojos}">
        <option value="<c:out value="${dojos.id}"/>">${dojos.name}</option>
        </c:forEach>
        </select>
    </p>
    <p>
        <label>First Name</label>
        <input name="firstName" type="text">
    </p>  
     <p>
        <label>Last Name</label>
        <input name="lastName" type="text">
    </p> 
     <p>
        <label>Age</label>
        <input name="age" type="number">
    </p> 
    <input type="submit" value="Create"/>
</form>
</body>
</html>