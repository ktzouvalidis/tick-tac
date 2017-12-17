<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Sign Up to Tick-Tac!</title>
	<!-- CSS -->
	<link rel="stylesheet" href="includes/bootstrap/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="includes/css/main.css" type="text/css"/>
	<!-- JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="includes/js/dynamic.js"></script>
	<script src="includes/js/utils.js"></script>
</head>
<body>
	<jsp:include page="/pages/header.jsp" />
	<jsp:include page="/pages/sidemenu.jsp"/>
		<% String feedback = (String)request.getAttribute("feedbackmessage"); %>
	<h5 style="color:red;"><%=(feedback!=null)?feedback:"" %></h5>
	<div class="container" style ="margin-top:15px">
		<div style="margin-left:40%">
			<div class="center">
				<div class="row">
					<div class="container-fluid banner"><h1>Sign Up</h1></div>
					<div class="col-lg-12">
						<form class="form-signup" id="form-signup" action="signup" method="post">
							<div class="form-group">
								<label for="name">Name</label>
								<input type="text" class="form-control" name="name" placeholder="Name" required/>
							</div>
							<div class="form-group">
								<label for="surname">Surname</label>
								<input type="text" class="form-control" name="surname" placeholder="Surname" required/>
							</div>
							<div class="form-group">
								<label for="email">Email Address</label>
								<input type="email" class="form-control" name="email" placeholder="E-mail" required/>
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<input type="password" class="form-control" id="pass" name="pass" placeholder="Password" required/>
							</div>
							<div class="form-group">
								<label for="password">Confirm Password</label>
								<input type="password" class="form-control" id="cfmpass" name="cfmpass" placeholder="Password Confirmation" required/>
								<div class="error-message">
								<c:if test="${not empty requestScope.passValidation}">
									<b>Confirmation password must be the same as the password you entered.</b>
								</c:if>
								</div>
							</div>
							<div class="form-group" align="center">
								<input type="submit" class="btn btn-primary" name="submit" value="Sign Up!" style="background-color: #206dc4;"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>