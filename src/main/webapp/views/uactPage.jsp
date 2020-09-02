<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Unlock Account</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	</script>

<script>
	function checkPassword()
	{
		var newPwd=$('#newPassword').val();
		var confirmNewPwd=$('#confirmNewPassword').val();
		if(newPwd!=confirmNewPwd)
			{
				$('#err').text('New password & confirm password should be same');
				return false;
			}
		else
			{
				return true;
			}
	}
</script>
</head>
<body>
<h2>Unlock your account</h2>
<font color='red'><span id="err"></span></font>
<font color='red'><span>${pwdEr}</span></font>
<form:form action="unlockCheck" modelAttribute="uac" method="POST">
<table>
	
	<tr>
		<td>Your Email id: </td>
		<td>${email}</td>
		<form:hidden path="acctEmail" value="${email}" />
	</tr>
	<tr>
		<td>Enter your temporary password: </td>
		<td><form:password path="oldPassword"/></td>
	</tr>
	<tr>
		<td>Enter your new password: </td>
		<td><form:password path="newPassword"/></td>
	</tr>
	<tr>
		<td>Re-type your new password: </td>
		<td><form:password path="confirmNewPassword"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Unlock" onclick="javascript:return checkPassword()"></td>
	</tr>
</table>
</form:form>
</body>
</html>