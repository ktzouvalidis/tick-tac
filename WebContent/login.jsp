<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Login to Tick-Tac!</title>
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
	<div class="container" style ="margin-top:55px">
		<div style="margin-left:45%">
			<div class="center">
				<div class="row">
					<div class="col-lg-12">
						<form class="form-signin" action="login" method="post">
							<h2>Login</h2>
							<div class="form-group">
								<label for="email">Email Address</label>
								<input type="email" class="form-control" name="email" placeholder="E-mail" required/>
							</div>
							<div class="form-group">
								<label for="password">Password</label>
								<input type="password" class="form-control" name="password" placeholder="Password" required/>
							</div>
							<div class="form-group">
								<input type="submit" class="btn btn-primary" name="submit" value="Log In" style="background-color: #206dc4;"/>
							</div>
						</form>
					</div>
				</div>
				<div class="error-message">
				<c:choose>
					<c:when test="${empty requestScope.accountFound}"></c:when>
					<c:otherwise>
						<c:if test="${requestScope.accountFound == 0 }"><b>Email or password are not correct.</b></c:if>
					</c:otherwise>
				</c:choose>
				</div>
			</div>
		</div>
	</div>
</body>
</html>