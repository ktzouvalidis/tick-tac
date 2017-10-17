<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.HashMap"
    import="java.util.Map"
    import="java.util.HashSet"
    import="com.ticktac.business.Event"
    import="com.ticktac.data.EventDAO;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tick-Tac: Advanced Search</title>
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
	
	
	<%
		String category = (String) request.getAttribute("eventCategory");
		String venue = (String) request.getAttribute("eventVenue");
		String date = (String) request.getAttribute("eventDate");
		
		EventDAO evData = new EventDAO();
		HashSet<Event> eventList = new HashSet<Event>();
		Map<String , Event> eventMap = new HashMap <String, Event>();	
	 	eventMap = evData.returnEvents();
	 	
	 	for (Map.Entry<String,Event> entry : eventMap.entrySet()){
	 		//HERE use "entry" to set every event that has the category you want 
	 		//into an attribute.
	 		//Then when we are at the adSearchResult.jsp, we'll make all the events
	 		//inside this attribute appear.
	 		if(entry.getValue().getCategory().compareTo(category) == 0 
	 		   && entry.getValue().getVenue().compareTo(venue) == 0
	 		   && entry.getValue().getDate().compareTo(date) == 0) { %>
	 		
		 		<div class="center" style="background-color:#D3D2D2; border: 1px solid black; margin-top: 1%; margin-left: 1.5%"> <!-- margin-left: 35% -->

		 				<div style="background-color: #ff793f; text-align: center;">
		 					<%	out.println(entry.getValue().getTitle()); %>
		 				</div>
		 				<div style="float: left; clear: left; margin-top: 10px">
							<img src="<%=entry.getValue().getPicture()%>" alt="" height="150" width="260"/>
						</div>		
						<div style="float: left; clear: left; margin-top: 2px">
							<br/>
							<h6><%=entry.getValue().getInformaton()%><br/></h6>
							- Venue: <b><%=entry.getValue().getVenue()%></b><br/>
							- Date: <b><%=entry.getValue().getDate()%></b> <br/>
							- Ticket Price: <b><%=entry.getValue().getTicket_price()%></b> / Available: <b><%=entry.getValue().getTotal_tickets()%></b>
							<div style="text-align: right; margin-top: 7px"><a href="eventDetails.jsp">More info...</a></div>
						</div>
		 		</div>
		 <% 		
	 			eventList.add(entry.getValue());
	 		}
	 	}
		//out.println(category);
		
		%>
</body>
</html>