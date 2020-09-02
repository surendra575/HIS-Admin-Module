<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all Employees</title>
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

<script>
	function deleteRecord()
	{
		return confirm("Are you sure you want to delete this item");
		}

	
	function activateRecord()
	{
		return confirm("Are you sure you want to Activate this employee");
		}

	/*$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});*/
	$(document).ready(function() {
	$('#roleId').on('change',function(){
	this.form.submit();
	
	});
	
	});
	
</script>



</head>
<h2><u>All Employees</u></h2>
<br/>
${msg}
<br>
<body>

<form action="viewAllEmployees">
<table>
	<tr>
		<td>Select Role: </td>
		<td>
			<select name="role" id="roleId">
				<option value="">--Select--</option>
				<option value="CASE-WORKER"> case worker</option>
				<option value="ADMIN">admin</option>
			</select>
		</td>
	</tr>
</table>

</form>
<br/>
<br/>


<table border="1" id="contactTbl">
	<thead>
		<tr>
			<th>S.No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Role</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<div id="d1">
		<c:forEach items="${emps}" var="p" varStatus="cnt">
			<tr>
			<td>${cnt.count}</td>
			<td>${p.firstName} ${p.lastName}</td>
			<td>${p.email}</td>
			<td>${p.role}</td>
			<td>
				<a href="/edit/${p.eid}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${p.deleteSwitch eq 'NO'}">
					<a href="/delete/${p.eid}" onclick="return deleteRecord()" >Delete</a>
				</c:if>
				<c:if test="${p.deleteSwitch eq 'YES'}">
					<a href="/activate/${p.eid}" onclick="return activateRecord()" >Activate</a>
				</c:if>
			</td>
			</tr>
		</c:forEach>
		</div>		
	</tbody>	
</table>
<c:if test="${cpn > 1}">
	<a href="viewAllEmployees?pno=${cpn-1}">Previous</a>
</c:if>

<c:forEach begin="1" end="${tp}" var="pno">
	<c:if test="${cpn==pno}">
	${pno}
	</c:if>
	<c:if test="${cpn!=pno}">
		<a href="viewAllEmployees?pno=${pno}">${pno}</a>
	</c:if>
</c:forEach>
	
<c:if test="${cpn < tp}">
	<a href="viewAllEmployees?pno=${cpn+1}">Next</a>
</c:if>
</body>
</html>