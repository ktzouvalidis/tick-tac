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
	<!-- *************************************************** -->
	<!-- This inbox shows the messages consumned immediately -->
	<!-- *************************************************** -->
</head>
<body>
	<jsp:include page="/pages/header.jsp" />
	<jsp:include page="/pages/sidemenu.jsp"/>
	<div class="error-message">
		<c:if test="${requestScope.noMessages == 1 }"><b>No messages</b></c:if>
	</div>
	<a class="nav-link" href="sendmessage.jsp">Send new message to administrator</a>
	<div class="container">
		<div class="center">
				<!--<form method="post" action="sendmessage"> -->
					<c:set var="i" value="1" scope="page"/> <!-- Use to show the # of the message displayed -->
					<c:forEach items="${applicationScope['messages']}" var="m">
						<div class="row" style="background-color: #dadcef">
							<b>Message <i>#${i}</i></b><br>
							${m.text}
						</div><br>
						<c:set var="i" value="${i + 1}" scope="page"/>
					</c:forEach>
					<!--<input type="hidden" name="receiver" value="${i - 1}">
					<div class="form-group">
						<input type="submit" class="btn-default" value="Reply">
					</div> -->
				<!--</form> -->
		</div>
	</div>
</body>
</html>