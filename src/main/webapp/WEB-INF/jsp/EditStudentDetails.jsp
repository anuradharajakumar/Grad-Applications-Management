<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Edit Student Details</title>
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
					<a href="studentHome.html?userid=${userId }"> |Your
						Applications|</a>
				</h3></td>
			<td style="width: 30%;"><h3>
					<a href="NewApplication.html?userid=${userId }"> |New
						Application|</a>
				</h3></td>
		</tr>
	</table>

	<center>
		<h4>NEW APPLICATION</h4>
		<form:form modelAttribute="applications"
			action='EditStudentDetails.html?applicationId=${applications.applicationId }'
			method="post" class="form-inline">
			<table class="table table-hover" style="width: 50%;">


				<tr>

					<th colspan=6>Student Details :</th>


				</tr>
				<tr>
					<th>First Name :</th>
					<td><form:input path="studentInfo.firstName" type="text"
							name="firstName" class="form-control" placeholder="First Name"
							required="required" /></td>
					<th>Last Name :</th>
					<td><form:input path="studentInfo.lastName" type="text"
							name="lastName" class="form-control" placeholder="Last Name"
							required="required" /></td>
				</tr>

				<tr>

					<th>CIN :</th>
					<td><form:input path="studentInfo.cin" type="text" name="cin"
							class="form-control" placeholder="Campus Identification Number"
							required="required" /></td>
					<th>Email Id :</th>
					<td><form:input path="studentInfo.email" type="text"
							name="email" class="form-control" placeholder="Email id"
							required="required" /></td>
				</tr>
				<tr>
					<th>Contact :</th>
					<td><form:input path="studentInfo.contact" type="text"
							name="contact" class="form-control" placeholder="Contact Number"
							required="required" /></td>

					<th>Gender :</th>
					<td><form:select path="studentInfo.gender"
							class="form-control" required="required">
							<form:option value="Male"> Male </form:option>
							<form:option value="Female"> Female </form:option>
						</form:select>
				</tr>

				<tr>

					<th>Dob :</th>
					<td><form:input path="studentInfo.dob" type="date" name="dob"
							required="required" class="form-control" placeholder="MM/DD/YYYY"
							pattern="[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}" /></td>


					<th>Citizenship :</th>
					<td><form:input path="studentInfo.citizenship" type="text"
							name="citizenship" class="form-control" placeholder="Citizenship"
							required="required" /></td>
				</tr>

				<tr>
					<td colspan=2></td>
					<td colspan=2>
						<center>
							<input type="Submit" value="Save" class="btn btn-primary" />
						</center>
					</td>

				</tr>
			</table>
		</form:form>
	</center>


</body>
</html>