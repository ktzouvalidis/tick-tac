<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="sidenav" class="navbar navbar-inverse sidebar" style="padding-bottom: 60%">
	<nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
		Lorem Ipsum
		<ul id="sidenav-ul" class="nav navbar-nav"">
			<li><a class="nav-link" href="index.jsp">Explore Events</a></li>
			<li><a class="nav-link" href="#">etc...</a></li>
		
			<li> </li>
	
			<c:if test="${sessionScope.userBean !=null}">
				<li><a class="nav-link" href="addevent.jsp"> Add Events</a></li>
				<li><a class="nav-link" href="myevents.jsp"> Edit your events</a></li>	
				<li><a class="nav-link" href="editaccount.jsp">My Account</a></li>
			</c:if>
		</ul>
	</nav>
</div>