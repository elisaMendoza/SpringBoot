<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<div class="container">
<form method="POST" action="/result">
    <label>Your Name: <input type="text" name="name"></label><br><br>
    <label>Dojo Location:</label>
    <select name="dojo">
    <option value="Viña">Viña del Mar</option>
    <option value="Valparaíso">Valparaiso</option>
    <option value="Santiago">Santiago</option>
    </select><br><br>
    <label>Favorite Language:</label>
    <select name="language">
    <option value="Java">Java</option>
    <option value="Python">Python</option>
    <option value="C#">C#</option>
    </select><br><br>
    <label>Comment (optional):</label><br>
    <textarea rows="4" cols="50" name="comment"></textarea><br>
    <input type="submit" value="Submit">
</form>
</div>
</body>
</html>