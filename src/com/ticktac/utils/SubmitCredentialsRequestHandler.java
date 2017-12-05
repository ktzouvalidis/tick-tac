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

import com.ticktac.business.BankReturn;
import com.ticktac.business.CreditCard;

public class SubmitCredentialsRequestHandler implements RequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CreditCard creditCard = new CreditCard();
		
		
		creditCard.setCardNumber(request.getParameter("cardNumber"));
		creditCard.setCv2Number(Integer.parseInt(request.getParameter("cv2Number")));
		creditCard.setExpireMonth(Integer.parseInt(request.getParameter("expireMonth")));
		creditCard.setExpireYear(Integer.parseInt(request.getParameter("expireYear")));
		
		
		Client client = ClientBuilder.newClient();
		WebTarget webResource = client.target("http://localhost:8081").path("banking")
				.queryParam("cardNumber", creditCard.getCardNumber())
				.queryParam("cv2Number", creditCard.getCv2Number())
				.queryParam("expireMonth",creditCard.getExpireMonth())
				.queryParam("expireYear", creditCard.getExpireYear());
		
		BankReturn bankReturn = webResource.request().accept("applicatio/json").get(BankReturn.class);
		
		request.setAttribute("bankreturn", bankReturn);
		
		return "/InsertBankInfo.jsp";
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		return null;
	}
	
	

}
