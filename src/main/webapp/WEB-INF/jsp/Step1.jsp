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
<title>Step 1</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#deptChoose").change(
				function() {

			
			$.ajax('DepartmentLoad.html', {				
				
				cache : false,
				dataType : 'json',
				type: 'GET',
				//mimeType: 'application/json',
				contentType : 'application/json',
				data : {
					"id" : this.value
				},
				success : function(data) {			          
			           
				var list = data.programs;	
				$.each(list, function( index, value ) {
			        	     $('#programChoose')
			        	         .append($("<option></option>")
			        	         .attr("value",value.programId)
					        .text(value.programName)); 
			        	
			          
				}); 
										
				},
				
				error : function(val) {
					alert('error' + val);
				},
				
				failure : function(data) {
					alert('failure');
				}
				
			});

		});
		
		$("#btnclick").click(
				function() {
					alert($("#programChoose").value());
				});
		
	});
</script>



</head>
<body>

	<p align="right">
		<a href="logout.html"> Log Out</a> <br> <br> Welcome
		${username} !
	</p>



	<center>
		<h2 id='hello'>Graduate Program Applications</h2>

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
		<table class="table table-hover" style="width: 50%;">

			<form:form modelAttribute="applications"
				action='Step1.html?userid=${userId }' method="post"
				class="form-inline">
				<tr>
					<th colspan=2>Department & Program</th>
				</tr>

				<tr>
					<th>Term</th>
					<td><form:select path="term.termId" class="form-control" required="required">

							<c:forEach items="${terms }" var="t">
								<form:option value="${t.termId}"> ${t.term } - ${t.year } </form:option>
							</c:forEach>

						</form:select></td>
				</tr>


				<tr>
					<th>Department</th>
					<td><form:select path="dept.deptId" class="form-control"
							id="deptChoose" name="deptChoose" required="required">
							<form:options items="${departments}" itemValue="deptId"
								itemLabel="deptName" />
						</form:select></td>
				</tr>

				<tr>
					<th>Program</th>
					<td><form:select path="program.programId" class="form-control"
							id="programChoose" name="programChoose" required="required">
						</form:select></td>
				</tr>
				<tr>
					<td><input type="submit" name="next" value="Save & Continue" class="btn btn-primary" /></td>
				</tr>
			</form:form>
		</table>
	</center>


</body>
</html>