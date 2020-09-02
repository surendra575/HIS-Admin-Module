<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HIS</title>
<link rel="icon" type="image/png" href="images/lg.png"/> 

</head>
<body>
<header>
<h2>HIS</h2>
</header>
<section>
<form:form action="/login" modelAttribute="login"  method="POST">
	
	<table align="center">
		<tr>
			<td><h2 style="align:center" ><u>Login here</u></h2></td>
		</tr>
		
		<tr>
		<td colspan='2'><h3 style="color:red">${er}</h3></td>
		</tr>
		
		<tr>
			<td>Email: </td>
			<td><form:input path="email" required="true"/></td>
		</tr>
		<tr>
			<td>Password: </td>
			<td><form:password path="password" required="true"/></td>
		</tr>
		<tr>
		<td></td>
		<td><input type="submit" value="Login"></td>
		</tr>
		<tr>
		<td><a href="/forgot">Forgot Password</a></td>
		</tr>
	</table>
	
</form:form>
<br/>
</section>

<a href="/register">Register admin/case worker</a><br/><br/>
<a href="/regApplicant">Register applicant</a><br/><br/>
<a href="/plan">Register plan</a><br/><br/>
<a href="/viewAllApplicants">All Applicants</a><br/><br/>
<a href="/viewAllEmployees">All Employees</a><br/><br/>
<a href="/viewAllPlans">All Plans</a><br/><br/>


</body>
</html>