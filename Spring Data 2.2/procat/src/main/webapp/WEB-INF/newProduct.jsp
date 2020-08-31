<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
<h2>New Product</h2>
<form action="/products/new" method="post">
    <p>
        <label>Name</label>
        <input name="name" type="text">
    </p>   
    <p>
        <label>Description</label>
        <textarea name="description">Enter text here...</textarea>
    </p> 
    <p>
        <label>Price</label>
        <input name="price" type="number" step="any"/>
    </p> 
    <input type="submit" value="Create"/>
</form>
</body>
</body>
</html>