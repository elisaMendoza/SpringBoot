<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
</head>
<body>
<form action="/licenses/create" method="post">
    <p>
        <label>Person</label>
        <select name="person">
        <c:forEach var="person" items="${persons}">
        <option value="<c:out value="${person.id}"/>">${person.firstName} ${person.lastName}</option>
        </c:forEach>
        </select>
    </p>
    <p>
        <label>State</label>
        <input name="state" type="text">
    </p>  
     <p>
        <label>Expiration Date</label>
        <input name="expirationDate" type="date">
    </p> 
    <input type="submit" value="Create"/>
</form>
</body>
</html>