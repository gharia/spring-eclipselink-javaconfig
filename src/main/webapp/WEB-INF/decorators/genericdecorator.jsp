<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Common CSS section -->
<link href=<c:url value="/resources/css/bootstrap.min.css" /> rel="stylesheet" /> 
<!-- Common CSS section -->

<sitemesh:write property="page.css"/> <!-- Page specific CSS -->

<title>Yoursite: <sitemesh:write property='title' /></title>
</head>
<body>
	<div class="container">
		<h1>This is top nav</h1>
		<sitemesh:write property='body' />
	</div>
</body>

<!-- Common JS section -->
<script src=<c:url value="/resources/js/jquery-1.11.1.min.js" />></script>
<script src=<c:url value="/resources/js/bootstrap.min.js" />></script>
<!-- Common JS section -->

<sitemesh:write property="page.js"/> <!-- Page specific JS. In your page include JS inside <content tag="js"></content> tag. It will be inserted here -->

</html>