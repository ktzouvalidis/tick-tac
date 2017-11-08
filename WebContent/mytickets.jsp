<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>My Tickets</title>
	<!-- CSS -->
	<link rel="stylesheet" href="includes/bootstrap/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="includes/css/main.css" type="text/css"/>
	<!-- JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="includes/js/dynamic.js"></script>
</head>
<body>
	<jsp:include page="/pages/header.jsp" />
	<jsp:include page="/pages/sidemenu.jsp"/>
	
	<div class="container">
		<div class="center">
			<h2 class="form-signin-heading">Tickets Information</h2>
			<table class="table table-bordered" style="border-color: green;">
				<thead>
					<tr>
						<th>Code</th>
						<th>Date of purchase</th>
						<th>Event Title</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.ticketevent }" var="te">
						<tr>
							<td>${te.code }</td>
							<td>${te.date }</td>
							<td>${te.title }</td>
							<td>${te.price }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>