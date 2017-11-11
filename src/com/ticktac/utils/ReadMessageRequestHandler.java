package com.ticktac.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.User;

public class ReadMessageRequestHandler implements MessageRequestHandler {

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
			// Filtering the messages - receiver_id should be equal to the id of the current logged in user
			String selector =  "receiver_id=" + ((User) request.getSession().getAttribute("userBean")).getId();
			QueueBrowser browser = session.createBrowser(queue, selector);
			MessageConsumer consumer = session.createConsumer(queue, selector);
			
			connection.start();
			@SuppressWarnings("unchecked")
			Enumeration<Message> messageCollection = browser.getEnumeration();
			List<TextMessage> messages = new ArrayList<TextMessage>();
			// Browse the messages
			while(messageCollection.hasMoreElements()) {
				Message message = messageCollection.nextElement();
				
				if(message instanceof TextMessage) {
					messages.add((TextMessage) message);
					// ADMINSTRATOR - Should add the property 'sender_name' (sender's fullname) in a List to print it
				}
			}
			
			// Receive the messages
			while(true) {
				Message message = consumer.receive(1);
				if(message == null)
					break;
			}
			
			browser.close();
			session.close();
			connection.close();
			
			if(messages.isEmpty())
				request.setAttribute("noMessages", 1);
			else
				request.getServletContext().setAttribute("messages", messages);
			
			view = "inboxread.jsp";
		} catch(Exception e) {
			e.printStackTrace();
			return view;
		}
		return view;
	}

}
