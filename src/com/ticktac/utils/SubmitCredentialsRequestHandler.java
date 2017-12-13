package com.ticktac.utils;

import java.io.IOException;
import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Entity;

import com.ticktac.business.BankReturn;
import com.ticktac.business.BankTransaction;

public class SubmitCredentialsRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BankTransaction bankTransaction = new BankTransaction();
		String fullCardNumber = "";
		fullCardNumber += request.getParameter("cardNumber1") + request.getParameter("cardNumber2") +
				request.getParameter("cardNumber3") + request.getParameter("cardNumber4");
		
		bankTransaction.setCardNumber(fullCardNumber);
		bankTransaction.setCv2Number(Integer.parseInt(request.getParameter("cv2Number")));
		bankTransaction.setExpireMonth(Integer.parseInt(request.getParameter("expireMonth")));
		bankTransaction.setExpireYear(Integer.parseInt(request.getParameter("expireYear")));
		bankTransaction.setTicketsBought(Integer.parseInt(request.getParameter("ticketsBought")));
		bankTransaction.setTicketPrice(Integer.parseInt(request.getParameter("ticketPrice")));
		bankTransaction.setTotalAmount(bankTransaction.getTicketsBought()*bankTransaction.getTicketPrice());
		
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8081").path("/banking");
		BankReturn bankReturn = webResource.request("application/json").accept("application/json").post(Entity.entity(bankTransaction,MediaType.APPLICATION_JSON),BankReturn.class);

		
		//BankReturn bankReturn = webResource.request().accept("application/json").get(BankReturn.class);
		
		
		request.setAttribute("bankreturn", bankReturn);
		
		return "/InsertBankInfo.jsp";
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		return null;
	}
	
	

}
