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

  
	<%  
		Event ev = (Event) request.getAttribute("detailsEvent");
	%>

	
	<div class="center" style="position: absolute; top: 32%; left: 41%; 
	margin-top: -9em; margin-left: -15em;">
		<img src="<%=ev.getPicture()%>" alt="" height="460" width="900"  style="max-height: 100%; max-width: 100%; border: 1px solid black "/>
	</div>	
	
	<div class="center" style="position: absolute; top: 86%; left: 50%; background-color: #c2beff;
	margin-top: 5px; margin-left: -15em; width: 50%; border: 1px solid black">
			
		<h4><b><i><%=ev.getTitle()%></i></b></h4>
			
		<div style="float: left; clear: left; margin-top: 2px">
			<%=ev.getInformaton()%><br/><br/>
			- Venue: <b><%=ev.getVenue()%></b><br/>
			- Date: <b><%=ev.getDate()%></b> <br/>
			- Ticket Price: <b><%=ev.getTicket_price()%></b> / Tickets available: <b><%=ev.getTotal_tickets()%></b>
		</div>
				
		
	</div>

</body>
</html>