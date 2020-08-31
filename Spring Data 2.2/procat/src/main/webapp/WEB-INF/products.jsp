
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
</head>
<body>
<h2><c:out value="${product.name}"/></h2>
<form action="/products" method="post">
<input type="hidden"  value="<c:out value="${product.id}"/>" name ="product">
    <p>
        <label>Add Category</label>
        <select name="categories">
        <c:forEach var="cats" items="${categories}"> 
        <option value="<c:out value="${cats.id}"/>">${cats.name}</option>
        </c:forEach>
        </select>
    </p>
    <input type="submit" value="Add"/>
    </form>
</body>
<%--${product.getCategories()=='${cats.name}' ? 'selected="true"' : ''} --%>
</html>