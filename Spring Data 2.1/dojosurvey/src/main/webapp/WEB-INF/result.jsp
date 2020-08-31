<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
<link rel="stylesheet" type="text/css" href="css/result.css">
</head>
<body>
<div class="resultbox">
<h3>Submitted Info</h3>
<h5>Name: <c:out value="${name}"/></h5>
<h5>Dojo Location: <c:out value="${dojo}"/></h5>
<h5>Favorite Language: <c:out value="${language}"/></h5>
<h5>Comment: <c:out value="${comment}"/></h5>
</div>
</body>
</html>