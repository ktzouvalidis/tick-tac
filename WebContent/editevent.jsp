<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Tick-Tac: Event Editor</title>
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
	<c:if test="${not empty requestScope.failedDeletion }">
		<b>Couldn't delete this event... Please try again.</b>
	</c:if>
	</div>
	
	<div class="container" style="margin-left:31%; margin-top: 2%">
		<div class="center">
			<div class="row">
				<div class="col-lg-9">
					<form class="form-signin" action="updateevent" method="post" enctype="multipart/form-data">
						<h2 class="form-signin-heading">Edit Event</h2>
						<div class="form-group">
							<label for="title">Title</label>
							<input type="text" class="form-control" name="title" value="${sessionScope.eventBean.title}"/>
						</div>
            <div class="form-group">
								Status: <b>${sessionScope.eventBean.status}</b>
            </div>
						<div class="form-group">
							<div class="photo-container">
								<img src="${sessionScope.eventBean.photo }" alt="Event photo" />

							</div>
							<div class="form-group">
								<label for="title">Title</label>
								<input type="text" class="form-control" name="title" value="${sessionScope.eventBean.title}"/>
							</div>
							<div class="form-group">
								<div class="photo-container">
									<img src="${sessionScope.eventBean.photo }" alt="Event photo" />
								</div>
								<input type="file" class="form-control" name="photo" accept="image"/>
							</div>
							<div class="form-group">
								<label for="title">Date</label><br/>
								<input type="datetime-local" id="date" name="date" value="${sessionScope.eventBean.date}"/>
							</div>
							<div class="form-group">
								<label for="info">Event information</label>
								<textarea rows="5" cols="75" class="form-control" name="info" value="${sessionScope.eventBean.info}"></textarea>
							</div>
							<div class="form-group">
								<label for="ticketPrice">Ticket Price</label>
								<div class="col-sm-2">
									<fmt:parseNumber var="ticketPrice" type="number" value="${sessionScope.eventBean.ticketPrice}"/>
									<input type="number" class="form-control" name="ticketPrice" min="1" step="0.1" value="${ticketPrice}"/>
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
						<form class="form-signin" action="updateevent" method="post">
							<input type="hidden" name="cancellation" value="1"/>
							<div class="form-group">
								<input type="submit" class="btn-default" id="btn-delete" name="submit" value="Cancel Event"/>
							</div>
						</form>
						<form class="form-signin" action="updateevent" method="post">
							<input type="hidden" name="deletion" value="1"/>
							<div class="form-group">
								<input type="submit" class="btn-default" id="btn-delete" name="submit" value="Delete Event"/>
							</div>
						</form>
						
						
						<hr />
						<h2 class="form-signin-heading">Tickets Information</h2>
						<table class="table table-bordered" style="border-color: green;">
							<thead>
								<tr>
									<th>Name</th>
									<th>Date of purchase</th>
									<th>Amount</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${requestScope.ticketuser }" var="tu">
									<tr>
										<td>${tu.name } ${tu.surname }</td>
										<td>${tu.date }</td>
										<td>${tu.amount }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>