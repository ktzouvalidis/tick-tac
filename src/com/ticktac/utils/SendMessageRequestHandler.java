package com.ticktac.utils;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

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
	
	/*
	 * (non-Javadoc)
	 * Main message request handler
	 * @see com.ticktac.utils.MessageRequestHandler#handleRequest(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.jms.ConnectionFactory, javax.jms.Queue)
	 */
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, ConnectionFactory cf,
			Queue queue) throws ServletException, IOException {
		String view = "notfound.html";
		try {
			Connection connection = cf.createConnection();
			Session session = connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			TextMessage textMessage = session.createTextMessage(request.getParameter("message"));
			messageProducer.send(textMessage);
			
			messageProducer.close();
			session.close();
			connection.close();
			
			request.setAttribute("messageSent", 1);
			view = "inbox.jsp";
		} catch(Exception e) {
			request.setAttribute("messageSent", 0);
			e.printStackTrace();
		}
		
		return view;
	}

}
