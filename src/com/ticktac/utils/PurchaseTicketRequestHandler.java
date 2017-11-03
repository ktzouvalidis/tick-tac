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

public class PurchaseTicketRequestHandler implements RequestHandler{

	EventDAO evDAO;
	
	public PurchaseTicketRequestHandler() {
		evDAO = new EventDAO();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		
		Event eventBean = (Event)request.getSession().getAttribute("eventBean");
	  	User userBean = (User)request.getSession().getAttribute("userBean");
		String sView = "purchaseComplete.jsp";
		
		if (eventBean != null) {
			//Note: Decided not to have the option to buy multiple tickets, because they are all added to the same user.
			Event ev = evDAO.buyTicket(eventBean, em, tr);
			request.getSession().setAttribute("eventBean", ev);
		}
		
		return sView;
	}

}
