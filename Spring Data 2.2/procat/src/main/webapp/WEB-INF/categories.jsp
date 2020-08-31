<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category Page</title>
</head>
<body>
<h2><c:out value="${category.name}"/></h2>
<form action="/categories" method="post">
<input type="hidden"  value="<c:out value="${category.id}"/>" name ="category">
    <p>
        <label>Add Product</label>
        <select name="products">
        <c:forEach var="product" items="${products}"> 
        <option value="<c:out value="${product.id}"/>">${product.name}</option>
        </c:forEach>
        </select>
    </p>
    <input type="submit" value="Add"/>
    </form>
</body>
</html>