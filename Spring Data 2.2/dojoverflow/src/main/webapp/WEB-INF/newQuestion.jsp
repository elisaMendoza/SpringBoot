<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Question</title>
</head>
<body>
<h1>What's your question?</h1>
	<form:form method="POST" action="/questions/new" modelAttribute="newQuestion">
		<form:hidden path="id"/>
		
     <form:label path="question">Question:
     	<form:errors path="question"/>
     	<form:textarea path="question"/>
     </form:label><br>
     
     
     
     Tags: <input type="text" name="tagList"><br>
    
      <input type="submit" name="" value="Submit">
    </form:form>
</body>
</html>