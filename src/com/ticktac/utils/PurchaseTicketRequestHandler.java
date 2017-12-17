package com.ticktac.utils;

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ticktac.business.BankReturn;
import com.ticktac.business.BankTransaction;
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
	  	String exceptionType = new String ("microservice");
	  		  	
		if (eventBean != null) {
			try {
			
			//validate and register sale in bank
			BankTransaction bankTransaction = new BankTransaction();
			String fullCardNumber = "";
			fullCardNumber += request.getParameter("cardNumber1") + request.getParameter("cardNumber2") +
					request.getParameter("cardNumber3") + request.getParameter("cardNumber4");
			bankTransaction.setCardNumber(fullCardNumber);
			bankTransaction.setCv2Number(Integer.parseInt(request.getParameter("cv2Number")));
			bankTransaction.setExpireMonth(Integer.parseInt(request.getParameter("expireMonth")));
			bankTransaction.setExpireYear(Integer.parseInt(request.getParameter("expireYear")));
			bankTransaction.setTicketsBought(Integer.parseInt(request.getParameter("amount")));
			bankTransaction.setTicketPrice((int) (eventBean.getTicketPrice()));
			bankTransaction.setTotalAmount(bankTransaction.getTicketsBought()*bankTransaction.getTicketPrice());

			Client client = ClientBuilder.newClient();
			WebTarget webResource = client.target("http://localhost:8081").path("/banking");
			BankReturn bankReturn = webResource.request("application/json").accept("application/json").post(Entity.entity(bankTransaction,MediaType.APPLICATION_JSON),BankReturn.class);		
			request.setAttribute("bankreturn", bankReturn);
			

			
			//Add the ticket to the tick-tac database
			for(int i = 0; i < amount; i++) {
			  	Date currentDate = new Date();
			  	
				//Random 5-digit number to be used as Ticket Code (NOT the Ticket ID)
			  	int tCode = (int) (10000 + Math.random() * (99999-10000));
			  	
			  	//Increasing the number of sold tickets for this event by 1.
				eventBean = eventDAO.buyTicket(eventBean, em, tr);
			  	
				//Creating and adding the ticket to the database.
			  	Ticket ticket = new Ticket(tCode, currentDate, eventBean, userBean);
			  	ticketDAO.addTicket(ticket, userBean, eventBean, em, tr);

				request.getSession().setAttribute("eventBean", eventBean);
				eventDAO.editEventStatus(eventBean, false, em, tr);
			  	sView = "purchaseComplete.jsp";
			}
			} catch (javax.ws.rs.WebApplicationException e) {
				request.setAttribute("purchaseerror", "ERROR: you wrote wrong credentials or the bank service is down. "
						+ "Please contact your bank");
				sView = "ticketPurchase.jsp";	
			}
		}
			
		
		
		return sView;
	}

}
