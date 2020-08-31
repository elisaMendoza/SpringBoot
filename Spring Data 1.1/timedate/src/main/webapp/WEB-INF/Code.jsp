<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="css/code.css">
</head>
<body>
<div class="container">
<h3><c:out value="${error}"/></h3>
<h2>¿Cuál es el código secreto del Jedi?</h2>
<form method="POST" action="/c/form">
    <label> <input type="password" name="password"></label>
    <button>Ingresar</button>
</form>
</div>

</body>
</html>