<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contador de Visitas</title>
<%-- <link rel="stylesheet" type="text/css" href="css/date.css">
<script type="text/javascript" src="js/date.js"></script>--%>
</head>
<body>
<div class="container">
<h2>Has visitado la p�gina: <c:out value="${count}"/> veces</h2>
<a href="/">Probar otra visita?</a>
</div>
</body>
</html>