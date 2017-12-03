<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Tick-Tac: Home</title>
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
	<div class="row text-center text-lg-left" style="margin-left: 20%">
	<!-- NO WAY! -->
		<c:forEach items="${requestScope.randomEvents }" var="e">
			<div class="col-lg-3 col-md-3 col-xs-9" 
			 style="background-color: #faff98; margin-left: 6%; margin-top: 5%; border: 1px solid black">
				<form method="get" action="eventdetails">
					<input type="hidden" name="eventID" value="${e.id }"/>
					<div style="text-align: center; margin-top: 2px; margin-bottom: 6px">${e.title }</div>
					<div style="text-align: center; margin-top: 1px">
						<img src="${e.photo }" alt="[Event Photo]" height="150px" width="225px"/>
					</div>
					<br/>
					<c:set var="remainingTickets" value="${e.totalTickets - e.soldTickets }"></c:set>
					<p align="center">Tickets Remaining: <b>${remainingTickets }</b></p>
					<div style="text-align: center; margin-top: 5px; margin-bottom: 10px">
						<input type="submit" class="btn-default" value="Details"/>
					</div>
				</form>
			</div>
		</c:forEach>
	</div>
	<h1>Hello, welcome to this awesome bank</h1>
	<form action="BankController" method="post">
		Insert card credentials:
		<input type="number" name="cardNumber">
		<br>
		<br>
		Insert CV2 number:
		<input type="number" name="cv2Number">
		<br>
		<br>
		<input type ="submit" value="Submit card info">
	</form>
	
	<%String serviceString = (String)request.getAttribute("out"); %>
	<%= (serviceString!=null)?serviceString:"If connection to Bank Microservice works, you will get message here" %>
</body>
</html>