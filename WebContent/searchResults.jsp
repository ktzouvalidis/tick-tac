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
	<div class="center" style="background-color:#D3D2D2; border: 1px solid black"> <!-- margin-left: 35% -->
		<div class="row">
			<div class="container-fluid" style="background-color: #ff793f; overflow: auto;">
				<h3><b><%=eventBean.getTitle()%></b></h3>
			</div>
			<div class="col-lg-12" style="margin-top: 3%; margin-left: 12.5%"> <!--  -->
				<div style="top:25%; left: 25%"> <!-- style="margin-top: 3%; margin-left: 15%" -->
					<img src="<%=eventBean.getPicture()%>" alt="" height="350" width="550"/>
				</div>
			</div>
		</div>
	</div>
	
	<%! HashSet<Event> eventList = new HashSet<Event>();%>
	<% eventList.add(eventBean);
		application.setAttribute("eventList", new HashSet<Event>(eventList));
		for(Event listOfEvents : eventList){
			if (eventBean.getCategory().equals("Rock")){%>
				Rock Concert
				
		<%}
		}
	%>
</body>
</html>