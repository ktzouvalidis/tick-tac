package com.ticktac.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.Event;
import com.ticktac.data.EventDAO;
import java.util.List;

import com.ticktac.utils.AdvSearchRequestHandler;
import com.ticktac.utils.PurchaseTicketRequestHandler;
import com.ticktac.utils.RequestHandler;
import com.ticktac.utils.SearchRequestHandler;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Servlet implementation class SearchController
 */
@WebServlet(description = "This controller proccesses information about the users' search inputs.",
		urlPatterns = {"/searchResults","/advSearchResults", "/purchaseComplete"})
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> handlersMap = new HashMap<String, Object>();
	@PersistenceContext(unitName="ticktacUP")
	EntityManager em;
	@Resource
	UserTransaction tr;
	
    public SearchController() {
        super();
    }
    
    public void init() throws ServletException {
	    // This will read mapping definitions and populate handlersMap (reads URLs)
    	handlersMap.put("/searchResults", new SearchRequestHandler());
    	handlersMap.put("/advSearchResults", new AdvSearchRequestHandler());
    	handlersMap.put("/purchaseComplete", new PurchaseTicketRequestHandler());
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		String viewURL = "notfound.html";
		RequestHandler handler = (RequestHandler) handlersMap.get(path);
		
		if (handler != null) 
			viewURL = handler.handleRequest(request, response, em, tr);
			
		request.getRequestDispatcher(viewURL).forward(request, response);
		
		
	}

}
