<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>

<head>
<title>First Web Application</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form:form method="post" modelAttribute="employee">
			
			<fieldset class="form-group">
				<form:label path="id">Id</form:label>
				<form:input path="id" class="form-control"  />
				<form:errors path="id" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" type="text" class="form-control" required="required" />
				<form:errors path="firstName" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" type="text" class="form-control" required="required" />
				<form:errors path="lastName" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" type="text" class="form-control" required="required" />
				<form:errors path="email" cssClass="text-warning" />
			</fieldset>
			<button type="submit" class="btn btn-success">Save</button>
		</form:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
</body>
</html>