<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Student Registration</title>
</head>
<body>
	<a href="login.html"> Home</a>
	<form:form modelAttribute="user">
		<center>

			<h3>Graduate Program Applications</h3>

			<br>
			<h4>STUDENT REGISTRATION</h4>
			<br>
			<table border=0>

				<tr>
					<td>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">
								EmailId</label>
						</div>
					</td>
					<td>
						<div class="col-sm-10">
							<form:input path="email" type="text" name="email"
								class="form-control" id="inputEmail3" placeholder="Email Id" />
							<td><form:errors path="email" /></td>
						</div>

					</td>

				</tr>

				<tr>
					<td>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
						</div>
					</td>
					<td>
						<div class="col-sm-10">
							<form:input path="password" type="password" name="password"
								class="form-control" id="inputPassword3" placeholder="Password" />
							<td><form:errors path="password" /></td>
						</div>

					</td>
				</tr>

				<tr>
					<td>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">
								FirstName</label>
						</div>
					</td>
					<td>
						<div class="col-sm-10">
							<form:input path="firstName" type="text" name="firstName"
								class="form-control" id="inputEmail3" placeholder="First Name" />
							<td><form:errors path="firstName" /></td>
						</div>

					</td>

				</tr>

				<tr>
					<td>
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">
								Last Name</label>
						</div>
					</td>
					<td>
						<div class="col-sm-10">
							<form:input path="lastName" type="text" name="lastName"
								class="form-control" id="inputEmail3" placeholder="Last Name" />
							<td><form:errors path="lastName" /></td>
						</div>

					</td>

				</tr>

				<tr>
					<td></td>
					<td>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<br> <input type="submit" value="Register"
									class="btn btn-primary">

							</div>
						</div>
					</td>
				</tr>

			</table>
		</center>
	</form:form>


</body>
</html>