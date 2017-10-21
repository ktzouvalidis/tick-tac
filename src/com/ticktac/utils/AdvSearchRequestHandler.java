package com.ticktac.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class AdvSearchRequestHandler implements RequestHandler{

	
	public AdvSearchRequestHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Hey!");
		String sView = "";
	
		String eCateg = (String) request.getParameter("evCategory");
		String eVenue = (String) request.getParameter("evVenue");
		String eDate = (String) request.getParameter("evDate");
		
		if (eCateg == null || eVenue == null) {
	  		sView = "index.jsp";
	  	}
		else {
			request.setAttribute("eventCategory", eCateg);
			request.setAttribute("eventVenue", eVenue);
			request.setAttribute("eventDate", eDate);
			sView = "advSearchResults.jsp";
		}
		return sView;
	}
}
