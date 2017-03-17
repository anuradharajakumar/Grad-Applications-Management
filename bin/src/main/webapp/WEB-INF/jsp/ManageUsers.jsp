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
<title>Users</title>
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
		</table>
		<h4>USERS</h4>
		<table class="table table-hover">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>User Type</th>
				<th>Delete</th>
			</tr>

			<c:forEach items="${users }" var="user">
				<tr>
					<td>${user.firstName }</td>
					<td>${user.lastName }</td>
					<td>${user.email }</td>
					<td>${user.password }</td>
					<td>${user.userType.userTypeName }</td>
					<td><a href="DeleteUser.html?userId=${user.userId}">Delete</a></td>
				</tr>
			</c:forEach>



			<tr>
				<form:form modelAttribute="newUser" method="post"
					lass="form-horizontal">

					<td><form:input path="firstName" type="text" name="firstName"
							class="form-control" id="inputEmail3" placeholder="First Name" /> <form:errors
							path="firstName" /></td>

					<td><form:input path="lastName" type="text" name="lastName"
							class="form-control" id="inputEmail3" placeholder="Last Name" /> <form:errors
							path="lastName" /></td>

					<td><form:input path="email" type="text" name="email"
							class="form-control" id="inputEmail3" placeholder="Email" /> <form:errors
							path="email" /></td>
					<td><form:input path="password" type="text" name="password"
							class="form-control" id="inputEmail3" placeholder="Password" /> <form:errors
							path="password" /></td>
					<td><form:select path="userType.userTypeId"  class="form-control">
							<form:options items="${usertypes}" itemValue="userTypeId"
								itemLabel="userTypeName" />
						</form:select></td>

					<td>
						<center>
							<input type="submit" value="Add New User" class="btn btn-primary">
						</center>
					</td>

				</form:form>

			</tr>

		</table>

	</center>




</body>
</html>