<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Event Editor</title>
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
	<div class="error-message">
	<c:choose>
		<c:when test="${empty requestScope.successfullEdit}"></c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${requestScope.successfullEdit == 0 }"><b>Couldn't update the event's information... Please try again.</b></c:when>
				<c:when test="${requestScope.successfullEdit == -1 }"><b>You've got an event running... Cannot delete your account!</b></c:when>
				<c:otherwise><b>Successfully changed event's information!</b></c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	</div>
	<div class="container">
		<div class="center" style="background-color: #ededed">
			<div class="row">
				<div class="container-fluid banner"><h1>Event Editor</h1></div>
				<div class="col-lg-9">
					<form class="form-signin" action="updateevent" method="post">
						<h2 class="form-signin-heading">Edit Event</h2>
						<div class="form-group">
							<div class="photo-container">
								<img src="${sessionScope.eventBean.photo }" alt="Profile photo" />
							</div>
							<input type="file" class="form-control" name="photo" accept="image"/>
						</div>
						<div class="form-group">
							<label for="title">Title</label>
							<input type="text" class="form-control" name="title" value="${sessionScope.eventBean.title}"/>
						</div>
						<div class="form-group">
							<label for="title">Date</label>
							<input type="date" id="date" name="date" value="${sessionScope.eventBean.date}"/>
						</div>
						<div class="form-group">
							<label for="info">Event information</label>
							<textarea rows="5" cols="75" class="form-control" name="info" value="${sessionScope.eventBean.info}"></textarea>
						</div>
						<div class="form-group">
							<label for="ticketPrice">Ticket Price</label>
							<div class="col-sm-2">
								<input type="number" class="form-control" name="ticketPrice" min="1" value="${sessionScope.eventBean.ticketPrice}"/> <!-- Integer for now -->
							</div>
						</div>
						<div class="form-group">
							<label for="moreTickets">Add more tickets</label>
							<div class="col-sm-2">
								<input type="number" class="form-control" name="moreTickets" min="0" value="0"/>
							</div>
						</div>
						<div class="form-group">
							<input type="submit" class="btn-default" name="submit" value="Update"/>
						</div>
					</form>
					<form class="form-signin" action="editaccount" method="post">
						<input type="hidden" name="deletion" value="1"/>
						<div class="form-group">
							<input type="submit" class="btn-default" id="btn-delete" name="submit" value="Delete this event"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>