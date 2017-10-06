package com.ticktac.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticktac.data.UserDAO;

public class SignUpRequestHandler implements RequestHandler {
	UserDAO userDAO;
	
	public SignUpRequestHandler() {
		userDAO = new UserDAO();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		String name = (String)request.getParameter("name");
		String surname = (String)request.getParameter("surname");
	  	String email = (String)request.getParameter("email");
	  	String password = (String)request.getParameter("password");
		
		if(name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty())
			view = "signup.jsp";
		else {
			userDAO.addUser(name, surname, email, password);
			request.setAttribute("newUser", name);
			view = "index.jsp";
		}
		
		return view;
	}

}
