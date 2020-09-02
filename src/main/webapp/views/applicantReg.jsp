<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Applicant Registration</title>
<style type="text/css">
body
		{
			background-image:url("imgs/img2.jpg");
			
		}
form { 

top:300px;
width:550px;
height:450px;
margin: 0 auto; 
background-color:#EBF5FB;
font-weight:bold;
margin: 8% auto 10% auto;
padding:25px;

}
input[type=text], input[type=password]{
  width: 100%;
  padding: 10px;
  background: #f1f1f1;
}
input[type=radio] {
    border: 0px;
    width: 20%;
    height: 1.5em;
}
select {
        width: 250px;
        margin: 10px;
    }
</style>
</head>
<body>


<form:form action="/addApplicant" modelAttribute="hem" method="POST">
<fieldset>
  <legend><h2>Applicant Registration</h2></legend>
  <h4 style="color:green">${msg}</h4>
  <h4 style="color:red">${emsg}</h4>
<table>
<form:hidden path="id"/>
	<tr>
		<td>First Name: </td>
		<td><form:input path="firstName"/></td>
	</tr>
	<tr>
		<td>Last Name: </td>
		<td><form:input path="lastName"/></td>
	</tr>
	<tr>
		<td>Date Of Birth: </td>
		<td><form:input  type="date"  path="dob"/>
		</td>
		
	</tr>
	<tr>
		<td>SSN:  </td>
		<td><form:input path="ssnNumber"/><span style="color:red">${ssnEr}</span>
		</td>
		
	</tr>
	<tr>
		<td>Email: </td>
		<td><form:input path="email"/>
		</td>
		
	</tr>
	<tr>
		<td>Phone Number: </td>
		<td><form:input path="phoneNumber"/>
		</td>
		
	</tr>
	
	<tr>
	<td>Gender: </td>
	<td><form:radiobutton path="gender" value="male"/>Male
	<form:radiobutton path="gender" value="female"/>Fe-male</td>
	</tr>
	<tr><br/></tr>
	
	
	<tr>
	<td><input type="reset" value="Reset"></td>
	<td><input type="submit" value="Submit">
	</tr>
	
	
</table>
</fieldset>
</form:form>
</body>
</html>