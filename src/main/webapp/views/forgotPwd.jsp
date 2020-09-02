<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forgot password</title>
</head>
<body>
<form:form action="/forgotpwd" modelAttribute="user" method="POST">
	<h2>Reset your password</h2>
	<table>
	<tr><h3 style="color:red">${er}</h3></tr>
	<tr><h3 style="color:green">${succ}</h3></tr>
	<tr>
		<td>Email: </td>
		<td><form:input path="email"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="submit"></td>
	</tr>
	</table>
</form:form>
<br/>
<a href="http://localhost:8086/home">Go back</a>
</body>
</html>