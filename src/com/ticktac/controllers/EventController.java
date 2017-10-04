package com.ticktac.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticktac.utils.AddEventRequestHandler;

/**
 * Servlet implementation class EventController
 */
@WebServlet("/*htm")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> handlersMap = new HashMap<String, Object>();
	
    public EventController() {
		handlersMap.put("/addevent.htm", new AddEventRequestHandler());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		//TODO More handlers
		if(path.equals("/addevent.htm")) {
			Object handler = handlersMap.get(request.getServletPath());
			
			if(handler == null)
				request.getRequestDispatcher("notfound.html").forward(request, response);
			else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
	}

}
