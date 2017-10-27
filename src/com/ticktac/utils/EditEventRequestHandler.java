package com.ticktac.utils;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.Event;
import com.ticktac.data.EventDAO;

public class EditEventRequestHandler implements RequestHandler {
	EventDAO eventDAO;
	
	public EditEventRequestHandler() {
		eventDAO = new EventDAO();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException{
		String view = "notfound.html";
		String title = request.getParameter("title");
		String date = request.getParameter("date");
		String photo = request.getParameter("photo");
		String info= request.getParameter("info");
		int ticketPrice = Integer.parseInt(request.getParameter("ticketPrice"));
		int moreTickets = Integer.parseInt(request.getParameter("moreTickets"));
		
	  	Event eventBean = (Event)request.getSession().getAttribute("eventBean");
	  	if(eventBean != null) {
	  		Event updatedEvent = eventDAO.updateEvent(eventBean, title, date, photo, info, ticketPrice, moreTickets, em, tr);
	  		if(updatedEvent != null)
  				request.getSession().setAttribute("eventBean", updatedEvent);
  			else
	  			request.setAttribute("successfullEdit", 0);
  			view = "editevent.jsp";
	  	}
		
		return view;
	}

}
