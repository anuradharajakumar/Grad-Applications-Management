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
<title>Insert title here</title>

<script type="text/javascript" src="javascript/jquery-2.1.1.min.js"> </script>
<script type="text/javascript">
	
</script>


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
		<form:form modelAttribute="applications"
			action='NewApplication.html?userid=${userId }' method="post"
			class="form-inline">
			<table class="table table-hover" style="width: 50%;">


				<tr>

					<th colspan=5>Student Details :</th>
					<th><p align="right">
							<a
								href="EditStudentDetails.html?studentInfoId=${applications.studentInfo.studentInfoId }">Edit</a>
						</p></th>

				</tr>
				<tr>
					<th>First Name :</th>
					<td>${applications.studentInfo.firstName }</td>
					<th>Last Name :</th>
					<td>${applications.studentInfo.lastName }</td>
				</tr>

				<tr>

					<th>CIN :</th>
					<td>${applications.studentInfo.cin }</td>
					<th>Email Id :</th>
					<td>${applications.studentInfo.email }</td>
				</tr>
				<tr>
					<th>Contact :</th>
					<td>${applications.studentInfo.contact }</td>

					<th>Gender :</th>
					<td>${applications.studentInfo.gender }</td>
				</tr>

				<tr>

					<th>Dob :</th>
					<td>${applications.studentInfo.dob }</td>


					<th>Citizenship :</th>
					<td>${applications.studentInfo.citizenship }</td>
				</tr>

				<tr>
					<td colspan=6>
						<hr />
					</td>
				</tr>


				<tr>

					<th colspan=5>Academic Details :</th>
					<th><p align="right">
							<a
								href="EditAcademicDetails.html?academicRecordId=${applications.academicRecords.academicRecordId }">Edit</a>
						</p></th>

				</tr>
				<tr>
					<th>TOEFL :</th>
					<td>${applications.academicRecords.toeflScore }</td>

					<th>GRE :</th>
					<td>${applications.academicRecords.greScore }</td>

				</tr>

				<tr>
					<th>GPA :</th>
					<td>${applications.academicRecords.gpa }</td>

					<th>TRANSCRIPT :</th>
					<td><a
						href='download.html?documentid=transcript_${userId }_${applications.academicRecords.transcript}'>
							${applications.academicRecords.transcript }</a></td>

				</tr>

				<tr>
					<td colspan=6>
						<hr />
					</td>
				</tr>




				<tr>

					<th colspan=6>Education Details :</th>
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
						<td>${degree.degreeEnd }</td>
						<td><a
							href="deleteDegree.html?id=${degree.educationalBackgroundId }&userid=${userId }">
								Delete </a></td>
					</tr>
				</c:forEach>
				</form:form>
				<tr>
					<form:form modelAttribute="neweducationalbackground"
						action='NewEducationalBackground.html?userid=${userId }'
						method="post" class="form-inline">
						<td><form:input path="university" type="text"
								name="university" class="form-control" placeholder="University" /></td>
						<td><form:input path="degree" type="text" name="degree"
								class="form-control" placeholder="Degree" /></td>
						<td><form:input path="major" type="text" name="major"
								class="form-control" placeholder="Major" /></td>
						<td><form:input path="degreeStart" type="date"
								name="degreeeStart" class="form-control"
								placeholder="Start date" /></td>
						<td><form:input path="degreeEnd" type="date" name="degreeEnd"
								class="form-control" placeholder="End date" /></td>
						<td><input type="submit" name="add" value="Add"
							action='NewEducationalBackground.html?userid=${userId }'
							class="btn btn-primary" method="post"></td>
					</form:form>
				</tr>

			</table>

			<input type="submit" name="save" value="Save" class="btn btn-primary">
			<input type="submit" name="submit" value="Submit"
				class="btn btn-primary">
	</center>




</body>
</html>