<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change your event</title>
	<!-- CSS -->
	<link rel="stylesheet" href="includes/bootstrap/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="includes/css/main.css" type="text/css"/>
	<!-- JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="includes/js/dynamic.js"></script>
</head>
<body>
	<%@ page import="com.ticktac.utils.Color" %>
    <jsp:include page="/pages/header.jsp" />
	<jsp:include page="/pages/sidemenu.jsp"/>
	<p> Your events</p>
	<c:if test="${not empty requestScope.successfullDeletion }"><b>Event deleted successfully</b></c:if>
	<c:if test="${not empty sessionScope.userBean }">
	<div class="row text-center text-lg-left">

		 
		<c:forEach items="${sessionScope.userBean.events}" var="e">
			<div class="col-lg-3 col-md-3 col-xs-9" 
			 style="background-color: #dadcef; margin-left: 6%; margin-top: 2%; border: 1px solid black">
				<form method="post" action="editevent">
					<input type="hidden" name="eventID" value="${e.id}">
					<div style="text-align: center; margin-top: 2px; margin-bottom: 6px">${e.title}</div>
					<b>Tickets sold: ${e.soldTickets}</b>
					<div style="text-align: center; margin-top: 1px">
						<img src="${e.photo}" alt="...Whoops?" height="150px" width="225px"/>
					</div>
					<div style="text-align: center; margin-top: 5px; margin-bottom: 5px">
						<input type="submit" class="btn-default" value="Edit">
					</div>
				</form>
			</div>
		</c:forEach>
	</div>
	</c:if>
		
</body>
</html>