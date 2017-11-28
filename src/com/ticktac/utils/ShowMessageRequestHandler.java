package com.ticktac.utils;

import java.io.IOException;
import java.util.List;

import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;

public class ShowMessageRequestHandler implements MessageRequestHandler {

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

		/*@SuppressWarnings("unchecked")
		List<Message> messages = (List<Message>) request.getServletContext().getAttribute("messages");
		Message m = (Message) messages.get(Integer.parseInt(request.getParameter("message_id")));
		try {
			if(m instanceof TextMessage) {
				TextMessage message = (TextMessage) m;
				request.setAttribute("message", message.getText());
				view = "showmessage.jsp";
			}
		} catch(Exception e) {
			e.printStackTrace();
		}*/

		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		WebTarget webtarget = client.target("http://localhost:8080/wsTest");
		String message = webtarget.path("rest").
				path("simple").request().
				accept(MediaType.TEXT_PLAIN).
				get(String.class);
		
		view = "showmessage.jsp";
		request.setAttribute("message", message);
		
		return view;
	}

}
