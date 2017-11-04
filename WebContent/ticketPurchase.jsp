<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tick-tac: Purchase your ticket!</title>
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
	
	<br/><br/>
	<div style="margin-left: 40%"> <!-- Add this cool style in the container class in main.css -->
		<div class="container">
			<form method="post"></form>
			<div class="center" style="background-color: #ededed">
				<div class="row">
					<div class="container-fluid banner"><h1>Payment</h1></div>
					<br/>
					<div class="col-lg-12" style="top:25px">
						<div class="form-group">
							<label for="cardnumber">Credit Card Number</label>
							<input type="text" class="form-control" name="cardnumber" placeholder="16 digits." required maxlength="16"/>
						</div>
						<div class="form-group">
							<label>Expiration Date</label><br/>
							<input lang="en" type="date" name="expiration" required>
						</div>
						<div class="form-group">
							<label for="cv2">CV2 Code</label>
							<input type="text" class="form-control" name="cv2" placeholder="Last 3 digits." required maxlength="16"/>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<br/>
	<div class="offset-6">
		<div class="row">
			<a href="purchaseComplete.htm" class="btn btn-primary" style="height: 40px; width: 220px ; align-content: center; color: black; background-color: #5373ff;">Complete your purchase!</a>
		</div>
	</div>

</body>
</html>