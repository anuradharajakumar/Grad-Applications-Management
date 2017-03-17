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
					<a href="NewApplication.html"> |New Application|</a>
				</h3></td>
		</tr>
	</table>

	<center>
		<h4>EDIT APPLICATION</h4>
		<table class="table table-hover" style="width: 50%;">

			<form:form modelAttribute="applications"
				action='EditApplicationDepartment.html?applicationId=${applications.applicationId }'
				method="post" class="form-inline">
				<tr>
					<th colspan=2>Department & Program</th>
				</tr>

				<tr>
					<th>Term</th>
					<td><form:select path="term.termId" class="form-control"
							required="required">

							<c:forEach items="${terms }" var="t">



								<form:option value="${t.termId}"> ${t.term } - ${t.year } </form:option>
							</c:forEach>

						</form:select></td>
				</tr>


				<tr>
					<th>Department</th>
					<td><label> ${applications.dept.deptName }</label></td>
				</tr>

				<tr>
					<th>Program</th>
					<td><form:select path="program.programId" class="form-control"
							id="deptChoose" name="deptChoose" required="required">

							<c:forEach items="${programs}" var="p">

								<form:option value="${p.programId }"> ${p.programName } </form:option>
							</c:forEach>


						</form:select></td>
				</tr>
				<tr>
					<td><input type="submit" name="next" value="Save" /></td>
				</tr>
			</form:form>
		</table>
	</center>




</body>
</html>