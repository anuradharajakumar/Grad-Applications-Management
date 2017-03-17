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
<title>Review Application</title>
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
					<a href="NewApplication.html?userid=${userId }">|New
						Application|</a>
				</h3></td>
		</tr>
	</table>

	<center>
		<h4>APPLICATION</h4>
		<form:form modelAttribute="applications" class="form-inline"
			action="ReviewApplication.html?applicationId=${applications.applicationId }">


			<table class="table table-hover" style="width: 50%;">

				<tr>
					<th colspan='4'><form:hidden path="applicationId" />
						Department & Program</th>
					<td><c:if
							test="${status.applicationstatus.status == 'Incomplete' || status.applicationstatus.status == 'Not Submitted' }">
							<p align='right'>

								<a
									href="EditApplicationDepartment.html?applicationId=${applications.applicationId }">
									Edit </a>
							</p>
						</c:if></td>
				</tr>
				<tr>
					<th>Department</th>
					<td><label>${applications.dept.deptName } </label></td>
				</tr>


				<tr>
					<th>Program</th>
					<td><label>${applications.program.programName } </label></td>
				</tr>


				<tr>
					<th>Term</th>
					<td><label>${applications.term.term } -
							${applications.term.year }</label></td>
				</tr>
			</table>


			<table class="table table-hover" style="width: 50%;">


				<tr>

					<th colspan=4>Student Details :</th>
					<td><c:if
							test="${status.applicationstatus.status == 'Incomplete' || status.applicationstatus.status == 'Not Submitted' }">
							<p align='right'>

								<a
									href="EditStudentDetails.html?applicationId=${applications.applicationId }">Edit</a>
							</p>
						</c:if></td>
				</tr>
				<tr>
					<th>First Name</th>
					<td><label>${applications.studentInfo.firstName } </label></td>
					<th>Last Name</th>
					<td><label>${applications.studentInfo.lastName } </label></td>
				</tr>

				<tr>
					<th>CIN</th>
					<td><label>${applications.studentInfo.cin } </label></td>
					<th>Email Id</th>
					<td><label>${applications.studentInfo.email } </label></td>

				</tr>

				<tr>
					<th>Gender</th>
					<td><label>${applications.studentInfo.gender } </label></td>
					<th>Dob</th>
					<td><label>${applications.studentInfo.dob } </label></td>
				</tr>
				<tr>
					<th>Citizenship</th>
					<td><label>${applications.studentInfo.citizenship } </label></td>
					<th>Contact</th>
					<td><label>${applications.studentInfo.contact } </label></td>
				</tr>

			</table>

			<hr />

			<table class="table table-hover" style="width: 50%;">


				<tr>

					<th colspan=4>Academic Details :</th>
					<td><c:if
							test="${status.applicationstatus.status == 'Incomplete' || status.applicationstatus.status == 'Not Submitted' }">
							<p align='right'>
								<a
									href="EditAcademicDetails.html?applicationId=${applications.applicationId }">Edit</a>
							</p>
						</c:if></td>

				</tr>
				<tr>
					<th>TOEFL :</th>
					<td><label>${applications.academicRecords.toeflScore }
					</label></td>
					<th>GRE :</th>
					<td><label>${applications.academicRecords.greScore } </label>
					</td>
				</tr>

				<tr>
					<th>GPA :</th>
					<td><label>${applications.academicRecords.gpa } </label></td>
					<th>TRANSCRIPT :</th>
					<td><label> <a
							href='download.html?documentid=transcript_${userId }_${applications.applicationId }_${applications.academicRecords.transcript}'>
								${applications.academicRecords.transcript }</a>
					</label></td>
				</tr>

			</table>

			<hr />

			<table class="table table-hover" style="width: 50%;">


				<tr>

					<th colspan=4>Education Details :</th>
					<td><c:if
							test="${status.applicationstatus.status == 'Incomplete' || status.applicationstatus.status == 'Not Submitted' }">
							<p align='right'>
								<a
									href="EditEducationalBackground.html?applicationId=${applications.applicationId }">Edit</a>
							</p>
						</c:if></td>

				</tr>
				<tr>
					<th>University</th>
					<th>Degree</th>
					<th>Major</th>
					<th>Degree Start</th>
					<th>Degree End</th>

				</tr>

				<c:forEach items="${applications.educationalBackground}"
					var="degree">
					<tr>
						<td>${degree.university }</td>
						<td>${degree.degree }</td>
						<td>${degree.major }</td>
						<td>${degree.degreeStart }</td>
						<td>${degree.degreeEnd }</td>

					</tr>
				</c:forEach>

			</table>
			<c:if
				test="${status.applicationstatus.status == 'Incomplete' || status.applicationstatus.status == 'Not Submitted' }">
				<input type="submit" name="save" value="Save"
					class="btn btn-primary">
				<input type="submit" name="submit" value="Submit"
					class="btn btn-primary">
			</c:if>
			<br><br><br>
			<hr/>


			<table class="table table-hover" style="width: 50%;">
				<tr>
					<td>Status: <label>${status.applicationstatus.status }
					</label>
					</td>

					<td>Comment: <label>${status.comment} </label></td>

				</tr>


			</table>


		</form:form>
	</center>




</body>
</html>