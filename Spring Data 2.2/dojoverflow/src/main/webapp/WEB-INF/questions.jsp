<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions Dashboard</title>
</head>
<body>
<h1>Question Dashboard</h1>
	
	<table>
		<tr>
			<td>Question</td>
			<td>Tag</td>
		<tr>
		<c:forEach items="${questions}" var="question" >
			<tr>
			<td> <a href="/questions/${question.id}"><c:out value="${question.question}"/></a> </td>
			<td>
				<c:forEach items="${question.tags}" var="tag" >
					<span> <c:out value="${tag.subject}"/> </span>
				</c:forEach>
			  </td>
			</tr>
		</c:forEach>
	</table>
		<a href="/questions/new">New Question</a>
</body>
</html>