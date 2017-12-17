package com.ticktac.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
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
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ticktac.business.Message;
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
			Client client = ClientBuilder.newClient();
			// Get the response of the service
			Response serviceResponse = client.target("http://localhost:8082").path("readmessages").
					path(String.valueOf(((User) request.getSession().getAttribute("userBean")).getId())).
					request(MediaType.APPLICATION_JSON).get(Response.class);
			// Then parse it to a list of Messages
			List<Message> messages = serviceResponse.readEntity(new GenericType<List<Message>>() {});
			
			if(messages.isEmpty())
				request.setAttribute("noMessages", 1);
			else
				request.getServletContext().setAttribute("messages", messages);
	
			view = "inboxread.jsp";
		} catch(Exception e) {
			request.setAttribute("noConnection", 1);
			view = "inboxread.jsp";
			e.printStackTrace();
		}
		
		return view;
	}
}
