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
	  		view = "/pages/login.html";
	  	else {
	  		User u = userDAO.searchUser(email, password);
	  		if(u == null)
	  			return "/pages/login.html?account=null";
	  		else {
	  			return "index.jsp?p=welcome";
	  		}
	  	}
	  	
		return view;
	}
}
