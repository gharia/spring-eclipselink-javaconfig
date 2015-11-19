<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<content tag="css">
<link href=<c:url value="/resources/css/bootstrap.min.css" /> rel="stylesheet">
<link href=<c:url value="/resources/css/bootstrapValidator.min.css" />  rel="stylesheet">
</content>
<title>Insert title here</title>
</head>
<body>
	
		<h2>${title}</h2>		
		
		
		<form:form class="form-horizontal" id="personform" role="form" method="post" commandName="person" action="${submitAction == 'update' ? s:mvcUrl('PC#update').build() : s:mvcUrl('PC#addPerson').build()}" >
			<form:input type="hidden"  path="id" id="id" />

			<div class="form-group form-group-sm">
				<form:label class="col-sm-2 control-label" for="firstname" path="firstname">First Name</form:label>

				<div class="col-sm-6">
					<form:input path="firstname" class="form-control" type="text" id="firstname" placeholder="First Name" />
					<form:errors class="error help-inline" path="firstname"/>
				</div>
			</div>
			<div class="form-group form-group-sm">
				<form:label class="col-sm-2 control-label" for="lastname" path="lastname">Last Name</form:label>

				<div class="col-sm-6">
					<form:input path="lastname" class="form-control" type="text" id="lastname" placeholder="Last Name" />
					<form:errors class="error" path="lastname"/>
				</div>
			</div>
			<div class="form-group form-group-sm">
				<form:label class="col-sm-2 control-label" for="address1" path="address1">Address1</form:label>

				<div class="col-sm-6">
					<form:input path="address1" class="form-control" type="text" id="address1" placeholder="Address Line 1" />
					<form:errors class="error" path="address1"/>
				</div>
			</div>
			<div class="form-group form-group-sm">
				<form:label class="col-sm-2 control-label" for="address2" path="address2">Address2</form:label>

				<div class="col-sm-6">
					<form:input path="address2" class="form-control" type="text" id="address2" placeholder="Address Line 2" />
					<form:errors class="error" path="address2"/>
				</div>
			</div>
			<div class="form-group form-group-sm">
				<form:label class="col-sm-2 control-label" for="city" path="city">City</form:label>

				<div class="col-sm-6">
					<form:input path="city" class="form-control" type="text" id="city" placeholder="City" />
					<form:errors class="error" path="city"/>
				</div>
			</div>
			<div class="form-group form-group-sm">
				<form:label class="col-sm-2 control-label" for="state" path="state">State</form:label>

				<div class="col-sm-6">
					<form:input path="state" class="form-control" type="text" id="state" placeholder="State" />
					<form:errors class="error" path="state"/>
				</div>
			</div>
			<div class="form-group form-group-sm">
				<form:label class="col-sm-2 control-label" for="zip" path="zip">Zip Code</form:label>

				<div class="col-sm-6">
					<form:input path="zip" class="form-control" type="text" id="zip" placeholder="Zip Code" />
					<form:errors class="error" path="zip"/>
				</div>
			</div>
			<div class="form-group form-group-sm">
				<form:label class="col-sm-2 control-label" for="email" path="email">Email</form:label>

				<div class="col-sm-6">
					<form:input path="email" class="form-control" type="text" id="email" placeholder="Email" />
					<form:errors class="error" path="email"/>
				</div>
			</div>
			<div class="form-group form-group-sm">
				<form:label class="col-sm-2 control-label" for="mobileno" path="mobileno">Mobile No</form:label>

				<div class="col-sm-6">
					<form:input path="mobileno" class="form-control" type="text" id="mobileno" placeholder="Mobile No" />
					<form:errors class="error" path="mobileno"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button id="savePerson" type="submit" class="btn btn-default">${submitBtnText}</button>
				</div>
			</div>
		</form:form>
	
</body>
<content tag="js">
<script src=<c:url value="/resources/js/bootstrapValidator.min.js" /> ></script>
<script src=<c:url value="/resources/js/person/person.js" /> ></script>
<script>


</script>
</content>
</html>