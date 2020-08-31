<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Queries</title>
</head>
<body>
<h2><c:out value="${numEjercicio}"></c:out></h2>
<table>
	<thead>
	<c:forEach items="${columns}" var="name">
	<th>${name}</th>
	</c:forEach>
</thead>
<tbody>
	<c:forEach items="${tabla}" var="row">
	<tr>
	<c:forEach items="${row}" var="data">
	<td>${data}</td>
	</c:forEach>
	</tr>
	</c:forEach>
</tbody>
</table>
</body>
</html>