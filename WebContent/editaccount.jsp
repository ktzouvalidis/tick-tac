<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Account Editor</title>
	<!-- CSS -->
	<link rel="stylesheet" href="includes/bootstrap/css/bootstrap.min.css" type="text/css"/>
	<link rel="stylesheet" href="includes/css/main.css" type="text/css"/>
	<!-- JS -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script src="includes/js/dynamic.js"></script>
	
	<jsp:useBean id="useBean" class="com.ticktac.business.User"/>
</head>
<body>
	<jsp:include page="/pages/header.jsp" />
	<jsp:include page="/pages/sidemenu.jsp"/>
	<div class="error-message">
	<c:choose>
		<c:when test="${empty requestScope.successfullEdit}"></c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${requestScope.successfullEdit == 0 }"><b>Please type your old password correctly.</b></c:when>
				<c:when test="${requestScope.successfullEdit == -1 }"><b>You've got an event running... Cannot delete your account!</b></c:when>
				<c:otherwise><b>Your account has been changed!</b></c:otherwise>
			</c:choose>
		</c:otherwise>
	</c:choose>
	</div>
	<div class="container">
		<div style="margin-left: 30%; margin-top: 25px">
			<div class="center">
				<div class="row">
					<div class="container-fluid banner"><h1>Account Editor</h1></div>
					<div class="col-lg-12">
						<form class="form-signin" action="editaccount" method="post">
							<h2 class="form-signin-heading">Edit Account</h2>
							<div class="form-group">
								<div class="photo-container">
									<img src="${userBean.photo }" alt="Profile photo" />
								</div>
								<input type="file" class="form-control" name="photo" accept="image"/>
							</div>
							<div class="form-group">
								<label for="name">Name</label>
								<input type="text" class="form-control" name="name" value="${userBean.name }" required/>
							</div>
							<div class="form-group">
								<label for="surname">Surname</label>
								<input type="text" class="form-control" name="surname" value="${userBean.surname }" required/>
							</div>
							<div class="form-group">
								<label for="password">Old Password</label>
								<input type="password" class="form-control" name="oldPassword" placeholder="Old Password" required/>
							</div>
							<div class="form-group">
								<label for="password">New Password</label>
								<input type="password" class="form-control" name="password" placeholder="New Password" required/>
							</div>
							<div class="form-group">
								<input type="submit" class="btn-default" name="submit" value="Change"/>
							</div>
						</form>
						<form class="form-signin" action="editaccount" method="post">
							<input type="hidden" name="deletion" value="1"/>
							<div class="form-group">
								<input type="submit" class="btn-default" id="btn-delete" name="submit" value="Delete my account"/>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>