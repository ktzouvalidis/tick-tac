package com.ticktac.utils;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.ticktac.business.User;
import com.ticktac.business.Message;

public class SendMessageRequestHandler implements MessageRequestHandler {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		return null;
	}
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, ConnectionFactory cf,
			Queue queue) throws ServletException, IOException {
		String view = "notfound.html";
		
		// Create the message with the required parameters
		Message message = new Message(((User)request.getSession().getAttribute("userBean")).getId(),
				((User)request.getSession().getAttribute("userBean")).getName() + " " + ((User)request.getSession().getAttribute("userBean")).getSurname(),
				1, request.getParameter("message"));
		
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8082").path("sendmessage");
		Message result = webTarget.request("application/json").accept("application/json").
				post(Entity.entity(message, MediaType.APPLICATION_JSON), Message.class);

		request.setAttribute("messageSent", 1);
		view = "sendmessage.jsp";
		
		return view;
	}
}
