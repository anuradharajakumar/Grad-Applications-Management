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
<title>Step 2</title>
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
			<td style="width: 20%;"><h3>
					<a href="studentHome.html?userid=${userId }"> |Your Applications|</a>
				</h3></td>
			<td style="width: 30%;"><h3>
					<a href="NewApplication.html?userid=${userId }"> |New
						Application|</a>
				</h3></td>
		</tr>
	</table>

	<center>
		<h4>NEW APPLICATION</h4>
		<table class="table table-hover" style="width: 50%;">

			<form:form modelAttribute="applications"
				action='Step2.html?applicationId=${applications.applicationId }' method="post"
				class="form-inline">
				<tr>

					<th colspan=2>Student Details :</th>

				</tr>
				<tr>
					<th>CIN</th>
					<td><form:input path="studentInfo.cin" type="number"
							name="cin" class="form-control" placeholder="CIN"  required="required"/></td>
				</tr>
				<tr>
					<th>First Name</th>
					<td><form:hidden path="studentInfo.studentInfoId"
							value="${applications.studentInfo.studentInfoId }" /> <form:input
							path="studentInfo.firstName" type="text" name="firstName"
							class="form-control" placeholder="First Name" required="required" /></td>

				</tr>
				<tr>
					<th>Last Name</th>
					<td><form:input path="studentInfo.lastName" type="text" name="lastName"
							class="form-control" placeholder="Last Name" required="required" /></td>
				</tr>

				<tr>
					<th>Email Id</th>
					<td><form:input path="studentInfo.email" type="text" name="email"
							class="form-control" placeholder="Email id" required="required" /></td>
				</tr>
				<tr>
					<th>Contact</th>
					<td><form:input path="studentInfo.contact" type="text" name="contact"
							class="form-control" placeholder="Contact Number" required="required"/></td>
				</tr>

				<tr>
					<th>Gender</th>
					<td><form:select path="studentInfo.gender" class="form-control" required="required">
							<form:option value="Male"> Male </form:option>
							<form:option value="Female"> Female </form:option>
						</form:select></td>
				</tr>
				<tr>
					<th>Dob</th>
					<td><form:input path="studentInfo.dob" type="text" name="dob"
							class="form-control" placeholder="MM/DD/YYYY" required="required" pattern="[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}" /></td>
				</tr>
				<tr>
					<th>Citizenship</th>
					<td><form:input path="studentInfo.citizenship" type="text"
							name="citizenship" class="form-control" required="required" placeholder="Citizenship" /></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" name="next" value="Save & Continue" /></td>
				</tr>
			</form:form>
		</table>
	</center>

</body>
</html>