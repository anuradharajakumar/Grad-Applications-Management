<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Step 4</title>
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

			<form:form modelAttribute="applications" class="form-inline">
				<tr>
					<th colspan=5>Education Details :</th>
					<td><input type="submit" value="Save & Continue"
						class="btn btn-primary" /> <form:hidden path="applicationId" /></td>

				</tr>
				<tr>
					<th>University</th>
					<th>Degree</th>
					<th>Major</th>
					<th>Degree Start</th>
					<th>Degree End</th>
					<th>Operation</th>
				</tr>

				<c:forEach items="${applications.educationalBackground}"
					var="degree">
					<tr>

						<td>${degree.university }</td>
						<td>${degree.degree }</td>
						<td>${degree.major }</td>
						<td>${degree.degreeStart }</td>
						<td>${degree.degreeEnd}</td>
						<td><a
							href="deleteDegree.html?eduid=${degree.educationalBackgroundId }&applicationId=${applications.applicationId }">
								Delete </a></td>
					</tr>
				</c:forEach>
			</form:form>
			<tr>
				<form:form modelAttribute="neweducationalbackground"
					action='NewEducationalBackground.html?applicationId=${applications.applicationId }'
					method="post" class="form-inline">
					<td><form:input path="university" type="text"
							name="university" class="form-control" placeholder="University"
							required="required" /></td>
					<td><form:input path="degree" type="text" name="degree"
							class="form-control" placeholder="Degree" required="required" /></td>
					<td><form:input path="major" type="text" name="major"
							class="form-control" placeholder="Major" required="required" /></td>
					<td><form:input path="degreeStart" type="text"
							name="degreeeStart" class="form-control" placeholder="Start date"
							pattern="[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}" required="required" /></td>
					<td><form:input path="degreeEnd" type="text" name="degreeEnd"
							class="form-control" placeholder="End date" required="required"
							pattern="[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}" /></td>
					<td><input type="submit" name="add" value="Add"
						class="btn btn-primary"></td>
				</form:form>
			</tr>

		</table>
	</center>

</body>
</html>