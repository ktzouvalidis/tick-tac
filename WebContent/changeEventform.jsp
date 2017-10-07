<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="eventBean" class="com.ticktac.business.Event"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	<p> Change the event ${eventBean.getTitle()}</p>
	
	<form action="updateEvent" method="post">
		<br> New date<br>
		<input type="text" name="newdate" value="${eventBean.getTitle()}">
		<br>
		<br> new price <br>
		<input type= "text" name="newprice" value="${eventBean.getTicket_price()}">
		<br>
		<br> new location <br>
		<input type= "text" name="newlocation" value="${eventBean.getVenue()}">
		<br>
		<input type="submit"  name="title" value="${eventBean.getTitle()}">
		
		
		
	</form>
</body>
</html>