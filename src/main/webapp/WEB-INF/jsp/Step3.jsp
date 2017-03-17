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
<title>Step 3</title>
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
		<table class="table table-hover" style="width: 50%;">

			<form:form modelAttribute="applications.academicRecords"
				action='Step3.html?applicationId=${applications.applicationId }'
				method="post" class="form-inline" enctype="multipart/form-data">
				<tr>
					<th colspan=2>Academic Details :</th>

				</tr>
				<tr>
					<th>TOEFL :</th>
					<td><form:input path="toeflScore" type="number"
							name="toeflScore" class="form-control" placeholder="TOEFL"
							required="required" /></td>
				</tr>
				<tr>
					<th>GRE :</th>
					<td><form:input path="greScore" type="number" name="greScore"
							class="form-control" placeholder="GRE" required="required" /></td>
				</tr>

				<tr>
					<th>GPA :</th>
					<td><form:input path="gpa" type="number" step="any" name="gpa"
							class="form-control" placeholder="GPA" required="required" /></td>
				</tr>

				<tr>
					<th>TRANSCRIPT :</th>
					<td><c:if
							test="${not empty applications.academicRecords.transcript}">
							<br>
							<form:label path="transcript"></form:label>
						</c:if> <input type="file" name="file0" class="form-control" required />
					</td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" name="next" value="Save & Continue"
						formaction="Step3.html?applicationId=${applications.applicationId }" /></td>
				</tr>
			</form:form>
		</table>
</body>
</html>