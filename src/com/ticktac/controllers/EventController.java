package com.ticktac.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticktac.utils.AddEventRequestHandler;
import com.ticktac.business.*;
import com.ticktac.data.*;

/**
 * Servlet implementation class EventController
 */
@WebServlet(urlPatterns = { "/addevent","/getevents" ,"/c.jsp","/toeventform.jsp", "/updateEvent", "/deleteEvent"})
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> handlersMap = new HashMap<String, Object>();
	private EventDAO events;
	
    public EventController() {
		handlersMap.put("/addevent.htm", new AddEventRequestHandler());
		 events=new EventDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		System.out.println(path);
		
		if( path.equals("/c.jsp")) {
			Vector<Event> events=new Vector<Event>();
			events.add(new Event());
			
			String name=(String)request.getSession().getAttribute("user");
			User user= new User();
			UserDAO users=new UserDAO();
			if(name!=null) {
				
			}
			events.add(new Event());
			request.setAttribute("events", events);
			System.out.println(name);
			request.getRequestDispatcher("changeEvent.jsp").forward(request, response);
			
			
		}else if(path.equals("/toeventform.jsp")) {
			System.out.println("miksi");
			String event=request.getParameter("title");
			
			
			request.setAttribute("eventBean", new Event());
			request.getRequestDispatcher("changeEventform.jsp").forward(request, response);
			
		}else if(path.equals("/addevent")) {
			
			request.getRequestDispatcher("addevent.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		EventDAO events= new EventDAO();
		
		//TODO More handlers
		if(path.equals("/addevent")) {
			Object handler = handlersMap.get(request.getServletPath());
			
			if(handler == null)
				request.getRequestDispatcher("login.jsp").forward(request, response);
			else {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else if(path.equals("/updateEvent") ) {
			
			String title=(String)request.getParameter("title");
			System.out.println(title);
			Event event= events.getInfo(title);
			if(event==null) {
				event=events.getInfo("Band");
			}
			event.setTicket_price(Double.parseDouble(request.getParameter("newprice")));
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else if(path.equals("/deleteEvent")) {
			
			String name= (String)request.getParameter("eventName");
			String user=(String)request.getSession().getAttribute("user");
			
			if(events.deleteEvent(name)) {
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			
			
			
		}
	}

}
