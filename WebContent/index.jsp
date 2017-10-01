<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Home Tick-Tac</title>
	
	<link rel="stylesheet" href="includes/bootstrap/css/bootstrap.min.css"/>
	<!-- JQuery -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<% String p = request.getParameter("p"); %>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<jsp:include page="/sidemenu.jsp"/>
	<div class="container">
		<% if(p == null) { %>
		<jsp:include page="/pages/home.jsp"/> <%}
		else {
			if(p.equals("welcome")) {
				/* What the actually fuck? p EQUALS welcome or login but doesn't include the pages.
				It did it 2 times that I tried but the rest of them not at all, without(!) touching the code*/%>
		<jsp:include page="/pages/welcome.jsp"/>
			<% } else if(p.equals("login")) { %>
		<jsp:include page="/pages/login.html"/>
		<%}}%>
	</div>
</body>
</html>