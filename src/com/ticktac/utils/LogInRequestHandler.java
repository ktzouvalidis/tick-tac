package com.ticktac.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticktac.business.User;
import com.ticktac.data.UserDAO;

public class LogInRequestHandler implements RequestHandler {
	UserDAO userDAO;
	
	public LogInRequestHandler() {
		userDAO = new UserDAO();
	}
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
	  	String email = (String)request.getParameter("email");
	  	String password = (String)request.getParameter("password");
	  	
	  	if(email == null || password == null)
	  		view = "login.jsp";
	  	else {
	  		User userBean = userDAO.searchUser(email, password);
	  		if(userBean == null) {
	  			request.getServletContext().setAttribute("accountExists", false);
	  			view = "login.jsp";
	  		}
	  		else {
	  			request.setAttribute("accountExists", true);
	  			request.getSession().setAttribute("user", userBean.getName());
	  			request.getSession().setAttribute("userBean", userBean);
	  			view = "index.jsp";
	  		}
	  	}
	  	
		return view;
	}
}
