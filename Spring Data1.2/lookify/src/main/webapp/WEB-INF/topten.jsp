<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Ten</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<h3>Top Ten Songs</h3>
<table>
    <tbody>
        <c:forEach items="${topSongs}" var="song">
        <tr>
            <td><c:out value="${song.rating}"/></td>
            <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
            <td><c:out value="${song.artist}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>