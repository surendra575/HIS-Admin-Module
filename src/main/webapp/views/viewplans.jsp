<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all contacts</title>
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
		return confirm("Are you sure you want to Activate this plan");
		}

	/*$(document).ready(function() {
		$('#contactTbl').DataTable({
			"pagingType" : "full_numbers"
		});
	});*/
</script>



</head>
<h2><u>All Plans</u></h2>
<br/>
${msg}
<br>
<body>

<table border="1" id="contactTbl">
	<thead>
		<tr>
			<th>S.No</th>
			<th>Plan Name</th>
			<th>Plan Description</th>
			<th>Plan Start Date</th>
			<th>Plan End Date</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<div id="d1">
		<c:forEach items="${plans}" var="p" varStatus="cnt">
			<tr>
			<td>${cnt.count}</td>
			<td>${p.planName}</td>
			<td>${p.planDescription}</td>
			<td>${p.planStartDate}</td>
			<td>${p.planEndDate}</td>
			<td>
				<a href="/editPlan/${p.planId}">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${p.activeSwitch eq 'YES'}">
					<a href="/deletePlan/${p.planId}" onclick="return deleteRecord()" >Delete</a>
				</c:if>
				<c:if test="${p.activeSwitch eq 'NO'}">
					<a href="/activatePlan/${p.planId}" onclick="return activateRecord()" >Activate</a>
				</c:if>
			</td>
			</tr>
		</c:forEach>
		</div>
	</tbody>
</table>

<c:if test="${cpn > 1}">
	<a href="viewAllPlans?pno=${cpn-1}">Previous</a>
</c:if>

<c:forEach begin="1" end="${tp}" var="pno">
	<c:if test="${cpn==pno}">
	${pno}
	</c:if>
	<c:if test="${cpn!=pno}">
		<a href="viewAllPlans?pno=${pno}">${pno}</a>
	</c:if>
</c:forEach>
	
<c:if test="${cpn < tp}">
	<a href="viewAllPlans?pno=${cpn+1}">Next</a>
</c:if>

</body>
</html>