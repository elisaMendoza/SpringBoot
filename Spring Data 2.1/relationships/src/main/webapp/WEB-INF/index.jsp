<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>People and Licenses</title>
</head>
<body>
<h2>Information</h2>
	<table>
		<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>License #</th>
			<th>State</th>
			<th>Expiration Date</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="person" items="${persons}">
			<tr>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.license.number}</td>
				<td>${person.license.state}</td>
				<td>${person.license.expirationDate}</td>				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>