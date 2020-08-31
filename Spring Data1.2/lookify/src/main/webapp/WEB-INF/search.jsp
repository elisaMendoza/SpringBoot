<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<form action="/search" method="post">
        <input name="artist" type="text" placeholder="name of artist"> 
    	<input type="submit" value="New search"/>
    	</form>
<h3>Songs by artist: <c:out value="${artist}"/></h3>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Rating</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songsArtist}" var="songs">
        <tr>
            <td><a href="/songs/${songs.id}"><c:out value="${songs.title}"/></a></td>
            <td><c:out value="${songs.rating}"/></td>
            <td><a href="/delete/${songs.id}">Delete</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>