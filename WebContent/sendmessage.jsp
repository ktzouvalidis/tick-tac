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
</head>
<body>
	<jsp:include page="/pages/header.jsp" />
	<jsp:include page="/pages/sidemenu.jsp"/>
	<div class="error-message">
		<!-- ADMINISTRATOR - One more check with value -1 to show that there is no user with that email account -->
		<c:choose>
			<c:when test="${requestScope.messageSent == 1 }"><b>Message sent!</b></c:when>
			<c:when test="${requestScope.messageSent == 0 }"><b>Message couldn't send... Please try again</b></c:when>
		</c:choose>
	</div>
	<div class="container">
		<div class="center" style="background-color: #ededed">
			<div class="row">
				<div class="col-lg-9">
					<form class="form-signin" action="sendmessage" method="post">
						<div class="form-group">
							<textarea rows="5" cols="75" class="form-control" name="message" placeholder="Your message"></textarea>
						</div>
						<div class="form-group">
							<input type="hidden" id="destination" name="destination" value="1"/> <!-- Knowing that the id of the administrator will be always 1 -->
							<input type="submit" class="btn-default" name="submit" value="Send"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>