package com.ticktac.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticktac.utils.BrowseMessageRequestHandler;
import com.ticktac.utils.MessageRequestHandler;
import com.ticktac.utils.SendMessageRequestHandler;
import com.ticktac.utils.ShowMessageRequestHandler;

/**
 * Servlet implementation class MessageController
 */
@WebServlet(description = "Controller for handling the messaging functions",
urlPatterns = { "/sendmessage", "/readmessage", "/browsemessages", "/showmessage"})
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, Object> handlersMap = new HashMap<String, Object>();	
	@Resource(mappedName="ticktacCF")
	ConnectionFactory cf;
	@Resource(mappedName="ticktacQueue")
	Queue queue;	
	
    public MessageController() {
        super();
    }
    
    public void init() {
		handlersMap.put("/sendmessage", new SendMessageRequestHandler());
		//handlersMap.put("/readmessage", new LogOutRequestHandler());
		handlersMap.put("/browsemessages", new BrowseMessageRequestHandler());
		handlersMap.put("/showmessage", new ShowMessageRequestHandler());
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String viewURL = "notfound.html";
		MessageRequestHandler handler = (MessageRequestHandler) handlersMap.get(path);
		
		if(handler != null)
			viewURL = handler.handleRequest(request, response, cf, queue);
		
		request.getRequestDispatcher(viewURL).forward(request, response);
	}

}
