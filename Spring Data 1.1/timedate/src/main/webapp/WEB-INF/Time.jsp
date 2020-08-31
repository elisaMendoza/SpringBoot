<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hora</title>
<link rel="stylesheet" type="text/css" href="css/time.css">
<script type="text/javascript" src="js/time.js"></script>
</head>
<body>
<div class="container">
<h2>Hora actual: <c:out value="${localTime}"/></h2>
</div>
</body>
</html>