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
	
	<div class="container" style="top: 25px">
		<div class="offset-4" style="margin-top: 20px;">
			<c:forEach items="${requestScope.events}" var="e">
				<br/>
				<div class="row">
					<div class="col-10" style="background-color: #D3D2D2; border: 1px solid black;">
						<form method="get" action="eventdetails">
							<input type="hidden" name="eventID" value="${e.id}">
							<br/>
							<div style="background-color: #ff793f; text-align: center">
								<h4><b>${e.title}</b></h4>
							</div>
							<br/>
								Status: <b>${e.status}</b>
							<br/>
							<div style="float: left; clear: left; margin-top: 3px"> <!--  -->
								<img src="${e.photo}" alt="Event photo" height="375" width="608" style="border: 1px solid black"/>
							</div>
							<div style="float: left; clear: left; margin-top: 2px">
								<br/>
								Soon at ${e.venue}!<br/><br/>
								- Category: <b>${e.category}</b> <br/>
							</div>
							<br/><br/>
							<div style="float: right; clear: left; margin-top: 6px" align="center">
								<input type="submit" value="More info..." class="btn btn-primary"
									style="color: black; background-color: #2659ff; margin-bottom: 12%">
							</div>
							<br/>
						</form><br/>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	
		
</body>
</html>