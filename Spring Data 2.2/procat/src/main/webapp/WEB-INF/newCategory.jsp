<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Category</title>
</head>
<body>
<h2>New Category</h2>
<form action="/categories/new" method="post">
    <p>
        <label>Name</label>
        <input name="name" type="text">
    </p>   
    <input type="submit" value="Create"/>
</form>
</body>
</html>