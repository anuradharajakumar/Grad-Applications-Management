<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Graduate Program Application</title>
</head>
<body>

	<p align="right">
		<a href="logout.html"> Log Out</a> <br> Welcome ${username} !
	</p>
	<center>

		<h3>Graduate Program Applications</h3>
	</center>
	<center>
		<table>
			<tr>
				<td><a href="ManageDepartments.html">Manage Departments</a></td>
			</tr>
			<tr>
				<td><a href="ManageUsers.html">Manage Users</a></td>
			</tr>

		</table>

	</center>
</body>
</html>