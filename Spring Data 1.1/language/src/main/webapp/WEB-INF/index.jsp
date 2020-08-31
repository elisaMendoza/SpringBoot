<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Languages</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Creator</th>
            <th>Version</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${language}" var="lans">
        <tr>
            <td><a href="/languages/${lans.id}"><c:out value="${lans.name}"/></a></td>
            <td><c:out value="${lans.creator}"/></td>
            <td><c:out value="${lans.currentVersion}"/></td>
    		<td><a href="/languages/delete/${lans.id}">Eliminar</a><a href="languages/edit/${lans.id}">Editar</a></td>
        </tr>
        </c:forEach>
    </tbody>
</table><br><br>

<h5>Agregar nuevo lenguaje</h5>
<form action="/languages" method="post">
    <p>
        <label>Name</label>
        <input name="name" type="text" placeholder="Nombre del lenguaje">
    </p>
    <p>
        <label>Creator</label>
        <input name="creator" type="text" placeholder="Nombre del creador">
    </p>
    <p>
        <label>Versión</label>
        <input name="currentVersion" type="text" placeholder="Versión">
    </p>   
    <input type="submit" value="Submit"/>
</form>
</body>
</html>