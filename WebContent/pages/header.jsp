<%String user = (String) session.getAttribute("user");%>
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
		<p class="navbar-text" style="padding-right: 40px">Signed in as: </p>
		<form class="form-inline">
       		<div class="form-group">
         			<ul style="list-style-type:none;margin-right: 10px;margin-bottom: 0%;line-height: 92%">
          				<li><input type="text" class="form-control" placeholder="Search" style="margin-right: 10px;margin-top: 10px"/></li>
          				<li><a href="advancedsearch.jsp">Advanced search...</a></li>
          			</ul>
         			<button type="submit" class="btn btn-primary">Search</button>
       		</div>
     		</form>
     		<div>
     			<ul class="navbar-nav">
				<%if(user == null) {%>
				<li class="nav-item">
					<a class="nav-link" href='login.jsp'>Log In</a>
				</li>
				<%} else {%>
				<li class="nav-item">
					<form action="logout.htm" method="post">
						<input type="submit" class="link-button btn" value="Log Out"/>
					</form>
				</li>
				<%} %>
				<li class="nav-item active">
					<a class="nav-link" href='#'>Sign Up</a>
				</li>
			</ul>
     		</div>
	</div>
</div>
