<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inbox</title>
   	<!-- CSS -->
	<link rel="stylesheet" href="includes/bootstrap/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="includes/css/main.css" type="text/css"/>
	<!-- JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="includes/js/dynamic.js"></script>
	<!-- ************************************************************ -->
	<!-- This inbox isn't used. Just keeping it in case of an upgrade -->
	<!-- ************************************************************ -->
</head>
<body>
	<jsp:include page="/pages/header.jsp" />
	<jsp:include page="/pages/sidemenu.jsp"/>
	<div class="error-message">
		<c:if test="${requestScope.noMessages == 1 }"><b>No messages</b></c:if>
	</div>
	<a class="nav-link" href="sendmessage.jsp">Send new message to administrator</a>
	<div class="container">
		<div class="row text-center text-lg-left">
			<c:set var="i" value="1" scope="page"/> <!-- Use to show the # of the message displayed -->
			<c:forEach items="${applicationScope['messages']}" var="m">
				<div class="col-lg-3 col-md-3" style="background-color: #dadcef">
					<form method="post" action="showmessage">
						<b>Message <i>#${i}</i></b>
						<input type="hidden" name="message_id" value="${i - 1}">
						<input type="submit" class="btn-default" value="Show message">
					</form>
				</div>
				<c:set var="i" value="${i + 1}" scope="page"/>
			</c:forEach>
		</div>
	</div>
</body>
</html>