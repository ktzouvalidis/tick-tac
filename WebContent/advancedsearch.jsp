<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
			<form class="form-horizontal bv-form" action="advSearchResults" method="POST">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td><label for="category">Category</label></td>
							<td>
								<select id="category" name="category">
									<option value="Concert">Concert</option>
							  		<option value="Festival">Festival</option>
							  		<option value="Expedition">Expedition</option>
							  		<option value="Theater">Theater</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label for="venue">Venue</label></td>
							<td>
								<input type="text" id="venue" name="venue" required/>
							</td>
						</tr>
						<tr>
							<td><label for="date">Date</label></td>
							<td><input lang="en" type="date" name="date"></td>
						</tr>
					</tbody>
				</table><br/>
				<p align="center">
					<input type="submit" class="btn btn-primary" value="Search"
					style="color: black; background-color: yellow"/>
				</p>
			</form>
		</div>
	</div>
</body>
</html>