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

	EventDAO evDAO;
	TicketDAO tickDAO;
	
	public PurchaseTicketRequestHandler() {
		evDAO = new EventDAO();
		tickDAO = new TicketDAO();
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
	  		  	
		if (eventBean != null) {
			//Note: Decided not to have the option to buy multiple tickets, because they are all added to the same user.
			Event ev = evDAO.buyTicket(eventBean, em, tr);
			request.getSession().setAttribute("eventBean", ev);

			//Random 5-digit number to be used as Ticket Code (NOT the Ticket ID)
		  	int tCode = (int) (10000 + Math.random() * (99999-10000));
		  	
		  	//Should we use the java.sql.Date import instead of java.util.Date? - (Kostas) java.util.Date is fine :)
		  	Date currentDate = new Date();
		  	
		  	//Creating and adding the ticket to the database.
		  	Ticket ticket = new Ticket(tCode, currentDate, eventBean, userBean);
		  	tickDAO.addTicket(ticket, userBean, em, tr);
		  	
		  	sView = "purchaseComplete.jsp";
		}
		
		return sView;
	}

}
