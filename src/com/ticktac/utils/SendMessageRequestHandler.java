package com.ticktac.utils;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.User;

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
			
			Message message = session.createTextMessage(request.getParameter("message")); // Always a TextMessage
			// The ID of the User as the receiver (Should be always 1 if the logged in user is not the administrator)
			message.setIntProperty("receiver_id", Integer.parseInt(request.getParameter("receiver")));
			// The ID of the User as the sender
			message.setIntProperty("sender_id", ((User)request.getSession().getAttribute("userBean")).getId());
			// The Fullname of the User as the sender 
			message.setStringProperty("sender_name", ((User)request.getSession().getAttribute("userBean")).getName() + " " +
					((User)request.getSession().getAttribute("userBean")).getSurname());
			
			messageProducer.send(message);
			
			messageProducer.close();
			session.close();
			connection.close();
			
			request.setAttribute("messageSent", 1);
			view = "sendmessage.jsp";
		} catch(Exception e) {
			request.setAttribute("messageSent", 0);
			e.printStackTrace();
		}
		
		return view;
	}

}
