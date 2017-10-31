<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div role="navigation" class="navbar navbar-toggleable-md navbar-inverse" style="background-color: #9fbc43">
	<div class="navbar-header" style="border-left: 3px solid #ffdd77; border-right: 3px solid #ffdd77;">
     	<a id="brand" class="navbar-brand nav-link" href="#"><img src="images/ticket.png" alt="" height="35" width="35" hspace="10" /><b>Tick - Tac</b></a>
    </div>
	<div class="collapse navbar-collapse" id="navbarText">
		<ul id="nav-ul" class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href='index.jsp'>Home</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href='#'>Tick</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href='#'>Tac</a>
			</li>
		</ul>
		<c:choose>
			<c:when test="${sessionScope.userBean == null }">
				<p class="navbar-text" style="padding-right: 40px">You are not signed in </p>
			</c:when>
			<c:otherwise>
				<p class="navbar-text" style="padding-right: 40px">Signed in as: ${sessionScope.userBean.name}</p>
			</c:otherwise>
		</c:choose>
		<form class="form-inline" action="searchResults" method="POST">
       		<div class="form-group">
         		<ul id="adv-search">
          			<li><input type="text" name="eTitle" class="form-control" placeholder="Search" style="margin-right: 10px;margin-top: 10px"/></li>
          			<li><a href="advancedsearch.jsp">Advanced search...</a></li>
          		</ul>
         		<button type="submit" class="btn btn-primary">Search</button>
       		</div>
		</form>
     		<div>
     			<ul class="navbar-nav">
				<c:choose>
					<c:when test="${sessionScope.userBean == null }">
					<li class="nav-item">
						<a class="nav-link" href='login.jsp'>Log In</a>
					</li>
					</c:when>
					<c:otherwise>
					<li class="nav-item">
						<a class="nav-link" href='logout'>Log Out</a>
					</li>
					</c:otherwise>
				</c:choose>
				<li class="nav-item active">
					<a class="nav-link" href='signup.jsp'>Sign Up</a>
				</li>
			</ul>
     		</div>
	</div>
</div>
