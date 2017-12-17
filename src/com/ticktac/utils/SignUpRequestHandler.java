package com.ticktac.utils;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.ticktac.business.BankReturn;
import com.ticktac.business.SignupReturn;
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
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setSurname(request.getParameter("surname"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("pass"));
		
		try {
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8085").path("/signup");
		SignupReturn signupReturn = webResource.request("application/json").accept("application/json").post(Entity.entity(user,MediaType.APPLICATION_JSON),SignupReturn.class);
		request.setAttribute("feedbackmessage", "Account was perfectly made. You can now log in and have fun");
		return signupReturn.getView();
		}catch (javax.ws.rs.WebApplicationException e) {
			request.setAttribute("feedbackmessage", "ERROR: E-mail probably exists, or something else is super wrong "
					+ "Please contact your internet provider");
			return "index.jsp";	
		}
	}

}
