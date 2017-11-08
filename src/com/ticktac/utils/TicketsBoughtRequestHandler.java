package com.ticktac.utils;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.TicketEvent;
import com.ticktac.business.User;
import com.ticktac.data.TicketDAO;

public class TicketsBoughtRequestHandler implements RequestHandler {

	TicketDAO ticketDAO;
	
	public TicketsBoughtRequestHandler() {
		ticketDAO = new TicketDAO();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		String view = "notfound";
		User user = (User) request.getSession().getAttribute("userBean");
		
		if(user != null) {
			List<TicketEvent> ticketevent = ticketDAO.getTicketsForUser(user, em, tr);
			
			if(ticketevent == null || ticketevent.isEmpty())
				request.setAttribute("noTickets", 0);
			else
				request.setAttribute("ticketevent", ticketevent);
			view = "mytickets.jsp";
		}
		return view;
	}

}
