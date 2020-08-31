<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile Page</title>
</head>
<body>
<h2><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h2>
<h4><c:out value="${person.license.number}"/></h4>
<h4><c:out value="${person.license.state}"/></h4>
<h4><c:out value="${person.license.expirationDate}"/></h4>
</body>
</html>