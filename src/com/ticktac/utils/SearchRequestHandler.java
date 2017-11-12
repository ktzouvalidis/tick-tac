package com.ticktac.utils;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.transaction.UserTransaction;

import com.ticktac.data.EventDAO;
import com.ticktac.business.Event;

public class SearchRequestHandler implements RequestHandler{
	
	private EventDAO eventDAO;
	
	public SearchRequestHandler() {
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
		String eTitle = null;	
		String view = "notfound.html";
	
		eTitle = request.getParameter("eTitle");
		
		if (eTitle != null) {
			if(eTitle.isEmpty())
				request.setAttribute("foundNothing", 0);
			else {
		  		List<Event> events = eventDAO.searchEvents(eTitle, em, tr);
		  		if (events != null && !events.isEmpty()) {
		  			//For every event we found, we check its status, in case it needs to be changed.
		  			for(Event e : events) 
		  				eventDAO.editEventStatus(e, false, em, tr); //boolean parameter checks if event is to be Cancelled.
					request.setAttribute("events", events);
		  		}
				else
					request.setAttribute("foundNothing", 0);
			}
			view = "searchResults.jsp";
		}
		return view;
	}
}
 