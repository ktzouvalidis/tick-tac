package com.ticktac.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

public class BrowseMessageRequestHandler implements MessageRequestHandler {
	
	/* A constant String that holds the property value of the receiver's ID
	 * -ID of the user that the message is sent to
	 */
	private final String RECEIVER_ID = "receiver";

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

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, ConnectionFactory cf,
			Queue queue) throws ServletException, IOException {
		String view = "notfound.html";
		try {
			Connection connection = cf.createConnection();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			QueueBrowser browser = session.createBrowser(queue); // Without filtering the messages
			
			connection.start();
			@SuppressWarnings("unchecked")
			Enumeration<Message> messageCollection = browser.getEnumeration();
			List<TextMessage> messages = new ArrayList<TextMessage>();
			while(messageCollection.hasMoreElements()) {
				Message message = messageCollection.nextElement();
				if(message instanceof TextMessage)
					messages.add((TextMessage) message);
			}
			browser.close();
			session.close();
			connection.close();
			
			if(messages.isEmpty())
				request.setAttribute("noMessages", 1);
			else
				request.getServletContext().setAttribute("messages", messages);
			
			view = "inbox.jsp";
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return view;
	}

}
