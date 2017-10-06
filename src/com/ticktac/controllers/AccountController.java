package com.ticktac.controllers;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ticktac.utils.LogInRequestHandler;
import com.ticktac.utils.LogOutRequestHandler;
import com.ticktac.utils.SignUpRequestHandler;
/**
 * AccountController
 */
@WebServlet(description = "Controller that processes information about Registration and Log in actions.",
urlPatterns = { "*.htm" })
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> handlersMap = new HashMap<String, Object>();
	
	public AccountController() {
        super();
    }
	
	public void init() {
		handlersMap.put("/login.htm", new LogInRequestHandler());
		handlersMap.put("/logout.htm", new LogOutRequestHandler());
		handlersMap.put("/signup.htm", new SignUpRequestHandler());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String viewURL = "notfound.html";
		Object handler = handlersMap.get(path);
		
		if(handler == null)
			viewURL = "notfound.html";
		
		switch(path) {
		case "/login.htm" :
			LogInRequestHandler logInHandler = (LogInRequestHandler) handler;
			viewURL = logInHandler.handleRequest(request, response);
			break;
		case "/logout.htm" :
			LogOutRequestHandler logOutHandler = (LogOutRequestHandler) handler;
			viewURL = logOutHandler.handleRequest(request, response);
			break;
		case "/signup.htm" :
			SignUpRequestHandler signUpHandler = (SignUpRequestHandler) handler;
			viewURL = signUpHandler.handleRequest(request, response);
			break;
		}

		request.getRequestDispatcher(viewURL).forward(request, response);
	}

}
