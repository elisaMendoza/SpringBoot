<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Song</title>
</head>
<body>
<a href="/dashboard">Dashboard</a><br><br>
<form action="/songs" method="post">
    <p>
        <label>Title</label>
        <input name="title" type="text" placeholder="Add title of song">
    </p>
    <p>
        <label>Artist</label>
        <input name="artist" type="text" placeholder="Add artist of song">
    </p>
    <p>
        <label>Rating (1-10)</label>
        <input name="rating" type="range" min="1" max="10">
    </p>   
    <input type="submit" value="Add song"/>
</form>
</body>
</html>