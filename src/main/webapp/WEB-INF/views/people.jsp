<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<content tag="css">
<link href=<c:url value="/resources/css/person/person.css" /> rel="stylesheet">
</content>
<title>${title}</title>
</head>
<body>

	
		<h2>Spring App Demo</h2>
		<div>
			<!-- <button type="button" class="btn btn-danger">Delete</button> -->
			<button type="button" class="btn btn-primary" onclick="location.href='person/new'">Add</button>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address1</th>
					<th>Address2</th>
					<th>City</th>
					<th>State</th>
					<th>Zip</th>
					<th>Mobile No</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${peopleList}" var="person" varStatus="i">
					<c:set var="index">${i.index+1}</c:set>
					
					<tr onclick="location.href='${s:mvcUrl('PC#updatePerson').arg(0,'{person.id}').buildAndExpand(index)}'">					
						<td><c:out value="${person.firstname}" /></td>
						<td><c:out value="${person.lastname}" /></td>
						<td><c:out value="${person.address1}" /></td>
						<td><c:out value="${person.address2}" /></td>
						<td><c:out value="${person.city}" /></td>
						<td><c:out value="${person.state}" /></td>
						<td><c:out value="${person.zip}" /></td>
						<td><c:out value="${person.mobileno}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>		
	
</body>
</html>