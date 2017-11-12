<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tick-Tac: Create Your Event!</title>
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
	<c:choose>
		<c:when test="${empty requestScope.eventExists }"></c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${requestScope.eventExists == 0 }"><b>Successfully added the event!</b></c:when>
				<c:when test="${requestScope.eventExists == 1 }"><b>An event with this name already exists!</b></c:when>
			</c:choose>
		</c:otherwise>
	</c:choose>
	</div>
	<div class="container" style="margin-top:25px">
		<div style="margin-left:40%">
			<div class="center">
				<div class="row">
					<div class="col-lg-9">
						<form action="addevent" method="post">
							<h2 class="form-signin-heading">Create Your Event!</h2>
							<div class="form-group">
					       		<label for="title">Name</label>
					        	<input type="text" class="form-control" id="title" name="title" required/>
					        </div>

							<div class="form-group">
								<label for="photo">Insert image url...</label>
								<input type="url" class="form-control" id="photo" name="photo" required/>
							</div>

							<div class="form-group">
						        <label for="date">Date</label>
						        <input type="datetime-local" class="form-control" id="date" name="date" required/>
					        </div>
							<div class="form-group">
					        	<label for="place">Place</label>
					        	<input type="text" class="form-control" id="place" name="place" required/>
					        </div>
							<div class="form-group">
					        	<label for="tickets">Available tickets</label><br>
					        	<input type="text" class="form-control" id="tickets" name="tickets" required/>
					        </div>
							<div class="form-group">
					        	<label for="price">Price</label>
					        	<input type="text" class="form-control" id="price" name="price" required/>
					        </div>
							<div class="form-group">
					        	<p>Select Category</p>
					        	<select name="category" class="form-control">
					        		    <option value="Concert">Concert</option>
								  		<option value="Festival">Festival</option>
								  		<option value="Expedition">Expedition</option>
								  		<option value="Theater">Theater</option>
					        	</select>
					        </div>
							<div class="form-group">
					        	<p>Add events information</p>
					        	<textarea rows="4" cols="50" name ="info" placeholder="Add events information"> </textarea>
					        </div>	
						   	<div class="form-group">
						 		<input type="submit"  class="btn-default" name="submit" value="Add Event"/>
							</div>
						</form>
			        </div>
	        	</div>
	       	</div>
       	</div>
   	</div>
</body>
</html>