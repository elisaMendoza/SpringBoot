<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lookify</title>
</head>
<body>
<a href="/songs/new">New Song</a>
<a href="/search/topTen">Top Songs</a><br><br>
<form action="/search" method="post">
        <input name="artist" type="search" placeholder="name of artist"> 
    	<input type="submit" value="Search artist"/>
    	</form>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/delete/${song.id}">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>