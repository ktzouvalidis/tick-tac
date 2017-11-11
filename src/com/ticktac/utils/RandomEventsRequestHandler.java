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


public class RandomEventsRequestHandler implements RequestHandler {
	
	private EventDAO eventDAO;
	private final int NUMBER_OF_RANDOM_EVENTS = 3;
	
	public RandomEventsRequestHandler() {
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
		
		List<Event> randomEvents = eventDAO.getRandomEvents(NUMBER_OF_RANDOM_EVENTS, em, tr);
		if(randomEvents != null) {
			if(!randomEvents.isEmpty())
				request.setAttribute("randomEvents", randomEvents);
			else
				request.setAttribute("noevents", 1);

			view = "home.jsp";
		}		
		
		return view;
	}

}
