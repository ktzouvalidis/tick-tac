package com.ticktac.utils;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.User;
import com.ticktac.data.UserDAO;

public class LogInRequestHandler implements RequestHandler {
	UserDAO userDAO;
	
	public LogInRequestHandler() {
		userDAO = new UserDAO();
	}
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		String view = "";
	  	String email = (String)request.getParameter("email");
	  	String password = (String)request.getParameter("password");
	  	
	  	if(email == null || password == null)
	  		view = "login.jsp";
	  	else {
	  		User userBean = userDAO.searchUser(email, password, em); // Doesn't need UserTransaction
	  		if(userBean == null) {
	  			request.setAttribute("accountFound", 0);
	  			view = "login.jsp";
	  		}
	  		else {
	  			request.setAttribute("accountFound", 1);
	  			request.getSession().setAttribute("userBean", userBean);
	  			view = "index.jsp";
	  		}
	  	}
	  	
		return view;
	}
}
