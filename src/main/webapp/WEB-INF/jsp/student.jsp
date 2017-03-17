<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Insert title here</title>
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
		<h4>APPLICATIONS</h4>
		<table class="table table-hover" style="width: 50%;">
			<tr>
				<th>Date Submitted</th>
				<th>Department</th>
				<th>Program</th>
				<th>Term</th>
				<th>Current Status</th>
				<th colspan=2>Operation</th>
			</tr>

			<c:forEach items="${applications_list }" var="appl">
				<tr>

					<td><c:if test="${ empty appl.key.dateSubmitted }">
					Not Submitted
					</c:if> <c:if test="${ not empty appl.key.dateSubmitted }">
							<fmt:formatDate pattern="MM/dd/yyyy"
								value="${appl.key.dateSubmitted }" />
						</c:if></td>
					<td>${appl.key.dept.deptName }</td>
					<td>${appl.key.program.programName }</td>
					<td>${appl.key.term.term}-${appl.key.term.year}</td>
					<td>${appl.value.status }</td>

					<c:if test="${appl.value.status == 'Incomplete' }">
							<td><a
								href="IncompleteApplication.html?applicationId=${appl.key.applicationId }">Complete</a></td>
						</c:if> 
						
						<c:if test="${appl.value.status == 'Not Submitted' }">
							<td><a
								href="SavedApplication.html?applicationId=${appl.key.applicationId }">Submit</a></td>
						</c:if> <c:if
							test="${appl.value.status != 'Not Submitted' &&  appl.value.status != 'Incomplete'}">
							<td><a
								href="ViewApplication.html?applicationId=${appl.key.applicationId }">View</a></td>
						</c:if>
					<td><a
						href="DeleteApplication.html?applicationId=${appl.key.applicationId }&userid=${userId }">Delete</a></td>




				</tr>
			</c:forEach>
		</table>
		<br> <br> <br>

	</center>


</body>
</html>