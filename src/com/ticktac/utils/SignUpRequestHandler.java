package com.ticktac.utils;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.User;
import com.ticktac.data.UserDAO;

public class SignUpRequestHandler implements RequestHandler {
	UserDAO userDAO;
	
	public SignUpRequestHandler() {
		userDAO = new UserDAO();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		String view = "";
		String name = (String)request.getParameter("name");
		String surname = (String)request.getParameter("surname");
	  	String email = (String)request.getParameter("email");
	  	String password = (String)request.getParameter("pass");
		
		if(name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty())
			view = "signup.jsp";
		else {
			if(userDAO.insertUser(new User(name, surname, email, password), em, tr)) {
				request.setAttribute("newUser", name);
				view = "index.jsp";
			}
		}
		
		return view;
	}

}
