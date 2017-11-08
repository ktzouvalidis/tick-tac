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
	
		<div class="container" style="top: 25px">
		<div class="offset-3">
			<div class="row">
				<div class="col-4">
					<img src="${sessionScope.eventBean.photo}" alt="Event photo" height="420" width="800"  style="border: 1px solid black "/>
				</div>	
			</div>
		</div>
		<br/>
		<div class="offset-4">
			<div class="row">
				<div class="col-10" style="background-color: #c2beff; border: 1px solid black;">
					<br/>
					<h4><b><i>${sessionScope.eventBean.title}</i></b></h4>
					- Venue: <b>${sessionScope.eventBean.venue}</b><br/>
					- Date: <b>${sessionScope.eventBean.date}</b><br/>
					- Ticket Price: <b>${sessionScope.eventBean.ticketPrice}</b> / Tickets available: <b>${sessionScope.eventBean.totalTickets - sessionScope.eventBean.soldTickets}</b>
				
					<br/><br/>
					Information: <br/>
					${sessionScope.eventBean.info}
				
					<br/>
				</div>
			</div>
			<br/>
			<div class="offset-9">
				<div class="row">
					<c:choose>
						<c:when test="${sessionScope.userBean == null }">
							<a href="login.jsp"><i>Login to purchase ticket...</i></a>
						</c:when>
						<c:otherwise>
							<a href="ticketPurchase.jsp" class="btn btn-primary" style="height: 40px; width: 120px ; align-content: center; color: black; background-color: yellow">Buy a ticket!</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</body>
</html>