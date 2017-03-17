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
<title>Departments</title>
</head>
<body>
	<p align="right">
		<a href="logout.html"> Log Out</a> <br> <br> Welcome
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
		</tr>
	</table>
	<center>
		<h4>DEPARTMENTS</h4>
		<table class="table table-hover" style="width: 50%;">
			<tr>
				<th>Department</th>
				<th>Number of Programs</th>
				<th colspan=2>Operation</th>
			</tr>

			<c:forEach items="${departments }" var="dept">
				<tr>
					<td>${dept.key.deptName }</td>
					<td>${dept.value }</td>
					<td><a href="ViewDepartment.html?deptId=${dept.key.deptId }">View/Edit</a></td>
					<td><a href="DeleteDepartment.html?deptId=${dept.key.deptId }">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br> <br> <br>
		<form:form modelAttribute="newDepartment" class="form-inline">
			<center>
				<table border=0>
					<tr>
						<td><form:input path="deptName" type="text" name="deptName"
								class="form-control" id="inputEmail3"
								placeholder="Department Name" /></td>


						<td><input type="submit" value="Add New Department"
							class="btn btn-primary"></td>
					</tr>
					<tr bordercolor="white">
						<td><form:errors path="deptName" /></td>
						<td></td>
					</tr>


				</table>

			</center>

		</form:form>

	</center>

</body>
</html>