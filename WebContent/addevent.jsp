<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<h1>Create your event.</h1>
	<form action="addevent" method="post">
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
		<div>
       		<label for="title">Name:</label><br>
        	<input type="text" id="title" name="title" required/><br>
        	<label for="date">Date</label><br>
        	<input type="date" id="date" name="date" required/><br>
        	<label for="place">Place</label><br>
        	<input type="text" id="place" name="place" required/><br>
        	<label for="tickets">Available tickets</label><br>
        	<input type="text" id="tickets" name="tickets" required/><br>
        	<label for="price">Price</label><br>
        	<input type="text" id="price" name="price" required/><br>
        	<p>select category</p>
        	<select name="category">
        		    <option value="movie">Classical</option>
			  		<option value="movie">Rock</option>
			  		<option value="musical">Metal</option>
			  		<option value="exposition">Hip-Hop</option>
        	</select><br>
        	<p>Add events information</p>
        	<textarea rows="4" cols="50" name ="info" placeholder="Add events information"> </textarea>
    	</div>
    		<div class="button">
  			<button type="submit">Add your event</button>
		</div>
	
	</form>
	
</body>
</html>