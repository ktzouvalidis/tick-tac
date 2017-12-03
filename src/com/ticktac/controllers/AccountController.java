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

import com.ticktac.utils.LogInRequestHandler;
import com.ticktac.utils.LogOutRequestHandler;
import com.ticktac.utils.EditAccountRequestHandler;
import com.ticktac.utils.RequestHandler;
import com.ticktac.utils.SignUpRequestHandler;
import com.ticktac.utils.TicketsBoughtRequestHandler;
/**
 * AccountController
 */
@WebServlet(description = "Controller that processes information about Registration and Log in actions.",
urlPatterns = { "/login", "/logout", "/signup", "/editaccount", "/mytickets" })
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> handlersMap = new HashMap<String, Object>();
	@PersistenceContext(unitName="ticktacUP")
	EntityManager em;
	@Resource
	UserTransaction tr;
	
	public AccountController() {
        super();
    }
	
	public void init() {
		handlersMap.put("/login", new LogInRequestHandler());
		handlersMap.put("/logout", new LogOutRequestHandler());
		handlersMap.put("/signup", new SignUpRequestHandler());
		handlersMap.put("/editaccount", new EditAccountRequestHandler());
		handlersMap.put("/mytickets", new TicketsBoughtRequestHandler());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String viewURL = "notfound.html";
		RequestHandler handler = (RequestHandler) handlersMap.get(path);
		
		if(handler != null)
			viewURL = handler.handleRequest(request, response, em, tr);
		
		RequestDispatcher rd = request.getRequestDispatcher(viewURL);
		rd.forward(request, response);
		//request.getRequestDispatcher(viewURL).forward(request, response); 
	}

}
