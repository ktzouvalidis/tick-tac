package com.ticktac.utils;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;



public class AdvSearchRequestHandler implements RequestHandler{

	
	public AdvSearchRequestHandler() {
		// TODO Auto-generated constructor stub
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
		
		String eCateg = (String) request.getParameter("evCategory");
		String eVenue = (String) request.getParameter("evVenue");
		String eDate = (String) request.getParameter("evDate");
		
		if (eCateg == null || eVenue == null) {
	  		view = "index.jsp";
	  	}
		else {
			request.setAttribute("eventCategory", eCateg);
			request.setAttribute("eventVenue", eVenue);
			request.setAttribute("eventDate", eDate);
			view = "advSearchResults.jsp";
		}
		return view;
	}
}
