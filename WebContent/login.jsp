<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Log In to Tick-Tac!</title>
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
	<div class="container">
		<div class="center" style="background-color: #ededed">
			<div class="row">
				<div class="container-fluid banner"><h1>Log In</h1></div>
				<div class="col-lg-12">
					<form class="form-signin" action="login" method="post">
						<h2 class="form-signin-heading">Log In</h2>
						<div class="form-group">
							<label for="email">Email Address</label>
							<input type="email" class="form-control" name="email" placeholder="E-mail"/>
						</div>
						<div class="form-group">
							<label for="password">Password</label>
							<input type="password" class="form-control" name="password" placeholder="Password"/>
						</div>
						<div class="form-group">
							<input type="submit" class="btn-default" name="submit"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>