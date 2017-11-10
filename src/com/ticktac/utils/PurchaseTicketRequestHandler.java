package com.ticktac.utils;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.Event;
import com.ticktac.business.Ticket;
import com.ticktac.business.User;
import com.ticktac.data.EventDAO;
import com.ticktac.data.TicketDAO;

public class PurchaseTicketRequestHandler implements RequestHandler{

	EventDAO eventDAO;
	TicketDAO ticketDAO;
	
	public PurchaseTicketRequestHandler() {
		eventDAO = new EventDAO();
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
		
		String sView = "notfound.html";
		Event eventBean = (Event)request.getSession().getAttribute("eventBean");
	  	User userBean = (User)request.getSession().getAttribute("userBean");
	  	int amount = Integer.parseInt(request.getParameter("amount"));
	  		  	
		if (eventBean != null) {
			for(int i = 0; i < amount; i++) {
			  	Date currentDate = new Date();
				//Random 5-digit number to be used as Ticket Code (NOT the Ticket ID)
			  	int tCode = (int) (10000 + Math.random() * (99999-10000));
			  	
				eventBean = eventDAO.buyTicket(eventBean, em, tr);
			  	//Creating and adding the ticket to the database.
			  	Ticket ticket = new Ticket(tCode, currentDate, eventBean, userBean);
			  	ticketDAO.addTicket(ticket, userBean, eventBean, em, tr);

				request.getSession().setAttribute("eventBean", eventBean);
				eventDAO.editEventStatus(eventBean, false, em, tr);
			  	sView = "purchaseComplete.jsp";
			}
		}
		
		return sView;
	}

}
