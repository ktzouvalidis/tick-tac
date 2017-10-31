<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	<%@ page import="com.ticktac.utils.Color" %>
    <jsp:include page="/pages/header.jsp" />
	<jsp:include page="/pages/sidemenu.jsp"/>
	<c:if test="${not empty requestScope.foundNothing }"><b>No events found...</b></c:if>
	
	<div class="row text-center text-lg-left">
		<c:forEach items="${requestScope.events}" var="e">
			<div class="col-lg-3 col-md-3 col-xs-9" style="background-color: #dadcef">
				<form method="get" action="eventdetails">
					<input type="hidden" name="eventID" value="${e.id}">
					<h2><b>${e.title}</b></h2><br>
					<input type="submit" class="btn-default" value="Details">
				</form>
			</div>
		</c:forEach>
	</div>
</body>
</html>