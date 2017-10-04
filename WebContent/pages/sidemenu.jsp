<%String user = (String) session.getAttribute("user");%>
<div id="sidenav" class="navbar navbar-inverse sidebar" style="padding-bottom: 35%">
	<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
		Lorem Ipsum
		<ul id="sidenav-ul" class="nav navbar-nav"">
			<li><a class="nav-link" href="index.jsp">Explore Events</a></li>
			<li><a class="nav-link" href="#">etc...</a></li>
			<%if(user != null) {%>
				<li><a class="nav-link" href="addevent.jsp"> Add Events</a></li>									
			<%}%>
			
		</ul>
	</nav>
</div>