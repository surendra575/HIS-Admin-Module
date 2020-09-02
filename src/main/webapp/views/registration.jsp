<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
<style type="text/css">
body
		{
			background-image:url("imgs/img1.jpg");
			
		}
form { 

top:300px;
width:600px;
height:480px;
margin: 0 auto; 
background-color:#BCD2DA;
font-weight:bold;
margin: 5% auto 10% auto;
padding:25px;

}
input[type=text], input[type=password],input[type=number]{
  width: 100%;
  padding: 10px;
  background: #f1f1f1;
}
input[type=radio] {
    border: 0px;
    width: 20%;
    height: 1.5em;
}

.s1
{
width: 230px;
        height: 30px;
        border: 1px solid #999;
        font-size: 15px;
        color: black;
        border-radius: 5px;
}

.b1 {
  background-color: #0F3B55; /* Green */
  border: none;
  color: white;
  padding: 15px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 50%;
}

</style>
<script>
function validateForm(){

var fname = document.getElementById("fname").value;
var lname = document.getElementById("lname").value;
var email=  document.getElementById("email").value;
var ph   = document.getElementById("phno").value;
	if (fname.length<1) {
        document.getElementById('er-fname').innerHTML = " Please Enter Your First Name *"  
        document.getElementById("fname").focus();    
        
    }
    if (lname.length<1) {
        document.getElementById('er-lname').innerHTML = " Please Enter Your Last Name *"
       
    }
    if (email.length<1) {
        document.getElementById('er-email').innerHTML = " Please Enter Your Email ID *"
       
    }
    if (ph.length<1) {
        document.getElementById('er-phno').innerHTML = " Please Enter Your ph number *"
       
    }
     if(fname.length<1 || lname.length<1 || email.length<1 || ph.length<1){
       	return false;
    }  
    
    
    }

</script>
</head>
<body>


<form:form action="/addEmployee" modelAttribute="hem" method="POST"  name="f1" onsubmit="return validateForm()">
<h4 style="color:green">${msg}</h4>
<h4 style="color:red">${emsg}</h4>
<fieldset>

  <legend><h1><u>Registration</u></h1></legend>
<table>
<form:hidden path="eid"/>
	<tr>
		<td>First Name: <span style="color:red">*</span></td>
		<td><form:input path="firstName" placeholder="First Name" id="fname"/><span style="color:red" id="er-fname"></span></td>
		
	</tr>
	<tr>
		<td>Last Name: <span style="color:red">*</span></td>
		<td><form:input path="lastName" placeholder="Last Name" id="lname"/><span style="color:red" id="er-lname"></span></td>
		
	</tr>
	<tr>
		<td>Email: <span style="color:red">*</span></td>
		<td><form:input path="email" placeholder="Email" id="email"/><span style="color:red" id="er-email">
		</td>
		
	</tr>
	<tr>
		<td>Phone Number: <span style="color:red">*</span></td>
		<td><form:input path="phoneNumber" placeholder="Phone Number" type="number" id="phno"/><span style="color:red" id="er-phno">
		</td>
		
	</tr>
	
	<tr>
	<td>Gender: </td>
	<td><form:radiobutton path="gender" value="male" checked="checked"/>Male
	<form:radiobutton path="gender" value="female"/>Fe-male</td>
	</tr>
	
	<tr>
		<td>Role: </td>
		<td><form:select path="role" class="s1">
			<form:option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-Select-   </form:option>
			<form:options items="${roles}"/>
			</form:select>	
		</td>
	</tr>
	<tr></tr><tr></tr>
	<tr>
	
	<td><button name="button"  class="b1" type="reset"><b>Reset</b></button></td> 
	<td><button name="button"  class="b1" type="submit"><b>Submit</b></button></td> 
	</tr>
	
	
</table>
</fieldset>
</form:form>
</body>
</html>