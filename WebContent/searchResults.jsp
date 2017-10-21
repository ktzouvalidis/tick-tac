<%@page import="com.ticktac.data.EventDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ticktac.business.Event" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="eventBean"
  scope="request"
  type="com.ticktac.business.Event" />

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tick-Tac: Event Search</title>
	<!-- CSS -->
	<link rel="stylesheet" href="includes/bootstrap/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="includes/css/main.css" type="text/css"/>
	<!-- JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="includes/js/dynamic.js"></script>
</head>
<body>
	<jsp:include page="/pages/header.jsp" />
	<jsp:include page="/pages/sidemenu.jsp"/><br/><br/>
	<div class="center" style="position: absolute; top: 37.5%; left: 50%; background-color:#D3D2D2; 
	margin-top: -9em; margin-left: -15em; max-width: 50%;border: 1px solid black">
	
	<form action="eventDetails.htm" method="GET">
			<div style="background-color: #ff793f; text-align: center;">
				<h4><b><%=eventBean.getTitle()%></b></h4>
				<input type="hidden" name="evDetailTitle" value="<%=eventBean.getTitle()%>">
			</div>
			<div style="float: left; clear: left; margin-top: 2px"> <!--  -->
					<img src="<%=eventBean.getPicture()%>" alt="" height="350" width="550"/>
			</div>			
			<div style="float: left; clear: left; margin-top: 2px">
				<br/>
				Soon at <%=eventBean.getVenue()%>!<br/><br/>
				- Category: <b><%=eventBean.getCategory()%></b> <br/>
				- Date: <b><%=eventBean.getDate()%></b> <br/>
				- Ticket Price: <b><%=eventBean.getTicket_price()%></b> / Tickets available: <b><%=eventBean.getTotal_tickets()%></b>
				<div style="text-align: right; margin-top: 7px"><input type="submit" value="More info..."></div>
			</div>
				
		</form>
	</div>
</body>
</html>