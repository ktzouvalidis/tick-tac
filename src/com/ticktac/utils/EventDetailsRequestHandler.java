package com.ticktac.utils;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.ticktac.business.Event;
import com.ticktac.business.Ticket;
import com.ticktac.data.EventDAO;
import com.ticktac.data.TicketDAO;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

public class EventDetailsRequestHandler implements RequestHandler{
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sView = "";

		
		
		String detTitle = (String) request.getParameter("evDetailTitle");
		System.out.println("The title is: " + detTitle);
		
		if (detTitle == null) {
			sView = "index.jsp";
		}
		else {
			System.out.println("The title is: " + detTitle);
			
			EventDAO evData = new EventDAO();
			//HashSet<Event> eventList = new HashSet<Event>();
			Map<String , Event> eventMap = new HashMap <String, Event>();
		 	eventMap = evData.returnEvents(); //We get all the registered events.
		 	
		 	for (Map.Entry<String,Event> entry : eventMap.entrySet()){ 
		 		if(entry.getValue().getTitle().compareTo(detTitle)==0) {
		 			request.setAttribute("detailsEvent",entry.getValue());
		 		}
		 	}
			sView = "eventDetails.jsp";
		}
		
		return sView;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		return null;
	}
}
