<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products and Categories</title>
</head>
<body>
<h2>Products</h2>
	<table>
		<thead>
		<tr>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Category</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.name}</td>
				<td>${product.description}</td>	
				<td>${product.price}</td>
				<td>${product.categories.size()} categories</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
 <h2>Categories</h2>
		<table>
		<thead>
		<tr>
			<th>Category Name</th>
			<th>Product Count</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.name}</td>
				<td>${category.products.size()} products</td>		
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>