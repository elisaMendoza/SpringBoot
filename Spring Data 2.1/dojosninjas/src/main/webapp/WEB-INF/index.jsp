<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas</title>
</head>
<body>
<h2>Information</h2>
	<table>
		<thead>
		<tr>
			<th>Dojo Name</th>
			<th>Ninja Count</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="dojos" items="${dojos}">
			<tr>
				<td>${dojos.name}</td>
				<td>${dojos.ninjas.size()} ninjas</td>		
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>