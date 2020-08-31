<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Language</title>
</head>
<body>
<a href="/languages">Dashboard</a><br><br>
<h4><c:out value="${language.name}"/></h4>
<h4><c:out value="${language.creator}"/></h4>
<h4><c:out value="${language.currentVersion}"/></h4>
<a href="/languages/edit/${language.id}">Edit</a><br><br>
<form action="/languages/${language.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>