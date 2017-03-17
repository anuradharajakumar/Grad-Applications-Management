<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Login</title>
</head>

<body>
	<br>
	<br>
	<center>
		<h3>Graduate Program Applications Login</h3>
		<br>
		<table border=0>
			<form:form modelAttribute="user" class="form-horizontal">
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
							<form:errors path="email" />
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
							<form:errors path="password" />
						</div>

					</td>

				</tr>
				<tr>
					<td align="left">
						<div class="form-group">


							<label class="col-sm-2 control-label"> <br> <a
								href="Register.html" class="btn btn-default"
								role="button"> Register </a>
							</label>

						</div>
					</td>
					<td>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<br> <input type="submit" value="Login"
									class="btn btn-primary">

							</div>
						</div>
					</td>
				</tr>
			</form:form>
		</table>
	</center>
</body>
</html>