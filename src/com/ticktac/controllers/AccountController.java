package com.ticktac.controllers;

import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.internal.oxm.mappings.Login;

import com.ticktac.utils.LogInRequestHandler;

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
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/login.htm")) {
			Object handler = handlersMap.get(request.getServletPath());
			if(handler == null)
				request.getRequestDispatcher("notfound.html").forward(request, response);
			else {
				LogInRequestHandler logInHandler = (LogInRequestHandler) handler;
				String viewURL = logInHandler.handleRequest(request, response);
				request.getRequestDispatcher(viewURL).forward(request, response);
			}
		}
	}

}
