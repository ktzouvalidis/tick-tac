<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.ticktac.business.Event;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tick-Tac: Event Details</title>
	<!-- CSS -->
	<link rel="stylesheet" href="includes/bootstrap/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="includes/css/main.css" type="text/css"/>
	<!-- JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="includes/js/dynamic.js"></script>

	<jsp:useBean id="evDetailBean" class="com.ticktac.business.Event"/>
</head>
<body>
	<jsp:include page="/pages/header.jsp" />
	<jsp:include page="/pages/sidemenu.jsp"/>
	<div class="container">
		<div class="center" style="background-color: #ededed">
			<div class="row">
				<h1><b>${sessionScope.eventBean.title}</b></h1>
				<div class="col-lg-9">
					<h2 class="form-signin-heading">Edit Event</h2>
					<div class="form-group">
						<div class="photo-container">
							<img src="${sessionScope.eventBean.photo}" alt="Event photo" />
						</div>
					</div>
					<div class="form-group">
						<h3><i>Date: </i></h3> <b>${sessionScope.eventBean.date}</b>
					</div>
					<div class="form-group">
						<h3><i>Ticket Price: </i></h3>	<b>${sessionScope.eventBean.ticketPrice}</b>
					</div>
					<div class="form-group">
						<h3><i>Available Tickets: </i></h3>
						<!-- Calculate the available tickets of this event -->
						<b>Tickets sold: ${sessionScope.eventBean.soldTickets } / ${sessionScope.eventBean.totalTickets}</b>
					</div>
					<div class="form-group">
						<h3><i>Event Information: </i></h3>
						<div class="col-sm-6">
							<p>${sessionScope.eventBean.info}"</p>
						</div>
					</div>
					<br/>
					<div class="offset-9">
						<div class="row">
							<c:choose>
								<c:when test="${sessionScope.userBean == null }">
									<a href="login.jsp"><i>Login </i></a> <i>to purchase ticket...</i>
								</c:when>
								<c:otherwise>
									<a href="ticketPurchase.jsp" class="btn btn-primary" style="height: 40px; width: 120px ; align-content: center; color: black; background-color: yellow">Buy a ticket!</a>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>