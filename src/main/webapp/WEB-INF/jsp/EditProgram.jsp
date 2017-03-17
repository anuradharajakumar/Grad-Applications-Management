<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Edit Program</title>
</head>
<body>

	<p align="right">
		<a href="logout.html"> Log Out</a> <br> Welcome
		${username} !
	</p>

	<center>
		<h2>Graduate Program Applications</h2>
	</center>
	<table border=0>
		<tr>
			<td></td>
			<td><a href="ManageUsers.html"><h3>| Users |</h3></a></td>
			<td><a href="ManageDepartments.html"><h3>| Departments
						|</h3></a></td>
			<td style="width: 10%;">&nbsp</td>
		</tr>
	</table>
	<center>
		<h4>Edit Program</h4>
		<form:form modelAttribute="program"
			action='EditProgram.html?deptId=${department.deptId}'
			class="form-inline">
			<table class="table table-bordered" style="width: 50%;">
				<tr>
					<th>Program Name</th>
					<td><form:input path="programName"
							value="${program.programName }" class="form-control" /></td>
					<form:errors path="programName" />
				</tr>
				<tr>
					<th>Department</th>
					<td><form:select path="dept.deptId" class="form-control">

							<c:forEach items='${departments}' var='deptmt'>

								<form:option value='${deptmt.deptId}'>${deptmt.deptName}</form:option>

							</c:forEach>


						</form:select></td>
				</tr>
				<tr>
					<td></td>
					<td><form:hidden path="programId"
							value="${program.programId }" /> <input type="submit"
						value="Change" class="btn btn-primary"></td>
				</tr>
			</table>
		</form:form>

		<a href="ViewDepartment.html?deptId=${department.deptId}"> <<< BACK </a>
	</center>
</body>
</html>