package com.ticktac.utils;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

public class LogOutRequestHandler implements RequestHandler {
	
	/*
	 * This is bad, I know. We can use a Design Pattern for this?
	 * Like a base interface RequestHandler and then two other interfaces that inherit from it?
	 */
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("userBean", null);
		return "index.jsp";
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		request.getSession().setAttribute("userBean", null);
		return "index.jsp";
	}

}
