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
<title>Application</title>
</head>
<body>

	<p align="right">
		<a href="logout.html"> Log Out</a> <br>Welcome ${username} !
	</p>
	<center>
		<h2>Graduate Program Applications</h2>
	</center>
	<table border=0 style="width: 60%;">
		<tr>
			<td style="width: 10%;"></td>
			<td style="width: 20%;"><h3>
					<a href="studentHome.html?userid=${userId }"> |Your Applications|</a>
				</h3></td>
			<td style="width: 30%;"><h3>
					<a href="NewApplication.html"> |New Application|</a>
				</h3></td>
			<td style="width: 10%;">&nbsp</td>
		</tr>
	</table>
	<center>
		<br>
		<h4>APPLICATION</h4>
		<table class="table table-bordered" style="width: 50%;">
			<tr>
				<th>Department</th>
				<td colspan=2>${application.dept.deptName }
				</th>
			</tr>

			<tr>
				<th>Program</th>
				<td colspan=2>${application.program.programName }</td>
			</tr>

			<tr>
				<th>Term</th>
				<td colspan=2>${application.term.term }-
					${application.term.year }</td>
			</tr>

			<tr>
				<th>Additional Docs</th>
				<td colspan=2>
					<table border=2>
						<c:forEach items="${documents}" var="doc">
							<tr>
								<th>${doc.key.docName }</th>
								<c:if test="${doc.key.docType == 'file' }">
								
								<td> <a href="download.html?file=${doc.value.additionalDocValue }"> ${doc.value.additionalDocValue }</a></td>
								</c:if>
								
								<c:if test="${doc.key.docType != 'file' }">
								<td>${doc.value.additionalDocValue }</td>
								</c:if>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>

			<tr>
				<th>Status</th>
				<td colspan=2>${status.applicationstatus.status }</td>
			</tr>

			<tr>
				<th>Comment</th>
				<td colspan=2>${status.comment }</td>
			</tr>
		</table>
		<br> <br>

	</center>


</body>
</html>