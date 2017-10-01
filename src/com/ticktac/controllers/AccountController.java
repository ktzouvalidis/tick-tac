package com.ticktac.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccountController
 */
@WebServlet(description = "Controller that processes information about Registration and Log in actions.", urlPatterns = { "*.html" })
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INDEX_PATH = "index.jsp";
	
	public AccountController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		if(path.equals("/login.html")) {
			
		}
	}

}
