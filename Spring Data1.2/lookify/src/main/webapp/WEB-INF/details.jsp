<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<a href="/dashboard">Dashboard</a><br><br>
<h4><c:out value="${song.title}"/></h4>
<h4><c:out value="${song.artist}"/></h4>
<h4><c:out value="${song.rating}"/></h4>
<a href="/delete/${song.id}">Delete</a>
</body>
</html>