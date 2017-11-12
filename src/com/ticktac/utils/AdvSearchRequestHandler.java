package com.ticktac.utils;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.Event;
import com.ticktac.data.EventDAO;



public class AdvSearchRequestHandler implements RequestHandler{

	private EventDAO eventDAO;
	
	public AdvSearchRequestHandler() {
		eventDAO = new EventDAO();		
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		String view = "notfound.html";
		
		String category = (String) request.getParameter("category");
		String venue = (String) request.getParameter("venue");
		String date = (String) request.getParameter("date");
		
		if (category != null && venue != null && date != null) {
			//Looks for events that match the parameters it received.
	  		List<Event> events = eventDAO.searchEvents(category, venue, date, em, tr);
	  		if(events != null && !events.isEmpty()) {
	  		//For every event we found, we check its status, in case it needs to be changed.
	  			for(Event e : events) 
	  				eventDAO.editEventStatus(e, false, em, tr); //boolean parameter checks if event is to be Cancelled.
				request.setAttribute("events", events);
	  		}
	  		else
				request.setAttribute("foundNothing", 0);

  			view = "searchResults.jsp";
		}
		return view;
	}
}
