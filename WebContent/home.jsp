<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "java.sql.Connection"
    import = "java.sql.DriverManager"
    import = "java.sql.PreparedStatement"
    import = "java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<h2>HOME</h2>
	
	<br/>

	<div class="row text-center text-lg-left" style="margin-left: 20%">
	<%
		//String s = "SELECT * FROM event ORDER BY RAND() LIMIT 3";
		
		Connection con;
		String url = "jdbc:mysql://localhost:3306/ticktac";
		String uName = "root";
		String password = "admin";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(url,uName,password);
		String sql = "SELECT * FROM event ORDER BY RAND() LIMIT 3";
		PreparedStatement prst = con.prepareStatement(sql);
		
		ResultSet rs = prst.executeQuery();
		while(rs.next()){
			String id = rs.getString("id");
			String title = rs.getString("title");
			int remainingTickets = (rs.getInt("totaltickets") - rs.getInt("soldtickets"));
			String photo = rs.getString("photo");
			//out.println("Title: " + title + " Remaining Tickets: " + remainingTickets + "<br/>");
			
	%>
		
			<div class="col-lg-3 col-md-3 col-xs-9" 
			 style="background-color: #dadcef; margin-left: 6%; margin-top: 5%; border: 1px solid black">
				<form method="get" action="eventdetails">
					<input type="hidden" name="eventID" value="<%=id%>"/>
					<div style="text-align: center; margin-top: 2px; margin-bottom: 6px"><%=title%></div>
					<div style="text-align: center; margin-top: 1px">
						<img src="<%=photo%>" alt="[Event Photo]" height="150px" width="225px"/>
					</div>
					<br/>
					<p align="center">Tickets Remaining: <b><%=remainingTickets%></b></p>
					<div style="text-align: center; margin-top: 5px; margin-bottom: 10px">
						<input type="submit" class="btn-default" value="Details"/>
					</div>
				</form>
			</div>
	<% 
		}
		
	%>
	</div>
</body>
</html>