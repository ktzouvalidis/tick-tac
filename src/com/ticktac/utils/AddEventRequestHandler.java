package com.ticktac.utils;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.Event;
import com.ticktac.business.User;
import com.ticktac.data.EventDAO;

public class AddEventRequestHandler implements RequestHandler {
	EventDAO eventDAO;
	
	public AddEventRequestHandler() {
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
		String view = "";
		String title = (String)request.getParameter("title");
		String date = (String)request.getParameter("date");
		String venue = (String)request.getParameter("place");
		String photo = (String)request.getParameter("photo");
		int totalTickets = Integer.parseInt(request.getParameter("tickets"));
		float ticketPrice = Float.parseFloat(request.getParameter("price"));
		String category = (String)request.getParameter("category");
		String info = (String)request.getParameter("info");
		User user = (User) request.getSession().getAttribute("userBean");
		
		if(user == null)
			view = "notfound.jsp";
		else {
			if(category.isEmpty() || info.isEmpty())
				view = "addevent.jsp";
			else {
				Event event = new Event(title, category, venue, date, info, ticketPrice, totalTickets, user,photo);
				
				//We check if the Event is Available, Sold Out or Finished. 
				//The State of the event is based on the number of available tickets and the date
				//eventDAO.createEventState(event);
				
				if(eventDAO.addEvent(event, user, em, tr)) {
					request.setAttribute("eventExists", 0);
					eventDAO.editEventStatus(event, false, em, tr);
				}
				else
					request.setAttribute("eventExists", 1);
					
				view = "addevent.jsp";
			}
		}
		
		return view;
	}

}
