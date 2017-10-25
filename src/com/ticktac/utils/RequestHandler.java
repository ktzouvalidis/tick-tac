package com.ticktac.utils;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

public interface RequestHandler {
	
	/*
	 * Previous handleRequest
	 */
	String handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException;
	/*
	 * Latest handleRequest method that gets the EntityManager and UserTransaction
	 * instances from the Controller
	 */
	String handleRequest(HttpServletRequest request,
			HttpServletResponse response, EntityManager em, UserTransaction tr)
					throws ServletException, IOException;
}
