<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Insert title here</title>
	
	<link rel="stylesheet" href="includes/bootstrap/css/bootstrap.min.css"/>
	<style>
		li {
		padding-right: 20px;
		font-size: 20px;
		}
		
		#brand {
		font-size: 32px;
		color: #99ffff;
		}
	</style>
</head>
<body padding-bottom="70px">
	<div role="navigation" class="navbar navbar-toggleable-md navbar-inverse" style="background-color: #204f07">
		<div class="navbar-header">
	     	<a id="brand" class="navbar-brand nav-link" href="#">Tick - Tac</a>
	    </div>
		<div class="collapse navbar-collapse" id="navbarText">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active">
					<a class="nav-link" href='#'>Hello</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href='#'>Tick</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href='#'>Tac</a>
				</li>
			</ul>
			<p class="navbar-text" style="padding-right: 40px">Signed in as: </p>
			<form class="form-inline">
        		<div class="form-group">
          			<input type="text" class="form-control" placeholder="Search">
          			<button type="submit" class="btn btn-default">Search</button>
        		</div>
      		</form>
      		<div>
      			<ul class="navbar-nav">
					<li class="nav-item">
						<a class="nav-link" href='#'>Log In</a>
					</li>
					<li class="nav-item active">
						<a class="nav-link" href='#'>Sign Up</a>
					</li>
				</ul>
      		</div>
		</div>
	</div>
</body>
</html>