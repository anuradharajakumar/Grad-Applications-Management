<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Edit Academic Details</title>
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
			action='EditAcademicDetails.html?applicationId=${applications.applicationId }'
			method="post" class="form-inline" enctype="multipart/form-data">
			<table class="table table-hover" style="width: 50%;">


				<tr>

					<th colspan=6>Academic Details :</th>


				</tr>
				<tr>
					<th>TOEFL :</th>
					<td><form:input path="academicRecords.toeflScore"
							type="number" name="toeflScore" class="form-control"
							placeholder="120" required="required" /></td>
					<th>GRE :</th>
					<td><form:input path="academicRecords.greScore" type="number"
							name="greScore" class="form-control" placeholder="340"
							required="required" /></td>
				</tr>

				<tr>

					<th>GPA :</th>
					<td><form:input path="academicRecords.gpa" type="number"
							name="gpa" class="form-control" step="any" placeholder="4.00"
							required="required" /></td>
					<th>TRANSCRIPT :</th>
					<td><label> ${applications.academicRecords.transcript }

					</label> <input type="file" name="file0" /></td>
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