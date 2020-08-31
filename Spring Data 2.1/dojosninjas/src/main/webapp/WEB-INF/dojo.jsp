<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Page</title>
</head>
<body>
<h2><c:out value="${dojo.name}"></c:out> Location Ninjas</h2>
<table>
		<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="ninjas" items="${dojo.ninjas}">
			<tr>
				<td>${ninjas.firstName}</td>
				<td>${ninjas.lastName}</td>
				<td>${ninjas.age}</td>				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>