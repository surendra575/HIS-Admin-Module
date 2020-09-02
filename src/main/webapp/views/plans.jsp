<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Plan Registration</title>
</head>
<body>
<h2>Plans</h2>
<h4 style="color:green">${msg}</h4>
<h4 style="color:red">${emsg}</h4>
<form:form action="/addPlan" modelAttribute="plan" method="POST">
<table>
<form:hidden path="planId"/>
	<tr>
		<td>Plan Name: </td>
		<td><form:input path="planName"/></td>
	</tr>
	<tr>
		<td>Plan Description: </td>
		<td><form:input path="planDescription"/></td>
	</tr>
	<tr>
		<td>Plan Start Date: </td>
		<td><form:input  type="date"  path="planStartDate"/>
		</td>
		
	</tr>
	
	<tr>
		<td>Plan End Date: </td>
		<td><form:input  type="date"  path="planEndDate"/>
		</td>
		
	</tr>
	
	
	
	<tr>
	<td><input type="reset" value="Reset"></td>
	<td><input type="submit" value="Submit">
	</tr>
	
	
</table>
</form:form>
</body>
</html>