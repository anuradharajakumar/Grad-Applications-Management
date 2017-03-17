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
<title>${department.deptName}Department</title>
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
			<td style="width: 20%;"><a href="ManageUsers.html"><h3>
					|Users|</h3></a></td>
			<td style="width: 30%;"><a
				href="ManageDepartments.html"><h3> |Departments|</h3></a></td>


			<td style="width: 10%;">&nbsp</td>
			<form:form modelAttribute="department" action='EditDepartment.html'
				method="post" class="form-inline">
				<td colspan = 2 style="width: 20%;"><form:input path="deptName" type="text" style="width: 100%;"
						name="deptName" value="${department.deptName }"
						class="form-control" id="inputEmail3" /></td>
				<td style="width: 10%;"><form:hidden path="deptId"
						value="${department.deptId }" /> <input type="submit"
					class="btn btn-primary" value="Change Department Name"></td>
			</form:form>
		</tr>
	</table>
	<center>
		<br>
		<h4>Programs :</h4>
		<table class="table table-bordered" style="width: 50%;">
			<tr>
				<th>Programs</th>
				<th colspan=2>Operation</th>
			</tr>

			<c:forEach items="${programs}" var="prog">
				<tr>
					<td>${prog.programName }</td>
					<td><a
						href="EditProgram.html?programId=${prog.programId }&deptId=${department.deptId}">
							Edit </a></td>
					<td><a
						href="DeleteProgram.html?programId=${prog.programId }&deptId=${department.deptId}">
							Delete </a></td>
				</tr>

			</c:forEach>
			<tr>
				<form:form modelAttribute="newProgram"
					action='NewProgram.html?deptId=${department.deptId}' method="post"
					class="form-inline">
					<td><form:input path="programName" type="text"
							name="programName" class="form-control"
							placeholder="Program Name" /> <form:errors path="programName" /></td>
					<td colspan=2>
						<center>
							<input type="submit" value="Add New Program"
								class="btn btn-primary">
						</center>
					</td>
				</form:form>
			</tr>
		</table>

		<h4>Additional Documents :</h4>
		<table class="table table-bordered" style="width: 50%;">
			<tr>
				<th>Additional Document</th>
				<th>Type</th>
				<th>Required</th>
				<th colspan=2>Operation</th>
			</tr>

			<c:forEach items="${documents}" var="doc">
				<tr>
					<td>${doc.docName }</td>
					<td>${doc.docType }</td>
					<td>${doc.required }</td>
					<td><a
						href="EditDocument.html?docId=${doc.docId }&deptId=${department.deptId}">
							Edit </a></td>
					<td><a
						href="DeleteDocument.html?docId=${doc.docId }&deptId=${department.deptId}">
							Delete </a></td>
				</tr>
			</c:forEach>
			<tr>
				<form:form modelAttribute="newAdditionalDocs"
					action='NewDocument.html?deptId=${department.deptId}' method="post"
					class="form-inline">
					<td><form:input path="docName" type="text" name="docName"
							class="form-control" id="inputEmail3" placeholder="Document Name" />
						<form:errors path="docName" /></td>
					<td><form:select path="docType" class="form-control">
							<form:option value="number" label="number" />
							<form:option value="text" label="text" />
							<form:option value="file" label="file" />
						</form:select></td>
					<td><form:radiobutton path="required" value="true"
							label="Required" /><br> <form:radiobutton path="required"
							value="false" label="Not Required" /></td>

					<td colspan="2"><input type="submit" value="Add New Document"
						class="btn btn-primary"></td>
				</form:form>
			</tr>

		</table>
		<br> <br>

	</center>
</body>
</html>