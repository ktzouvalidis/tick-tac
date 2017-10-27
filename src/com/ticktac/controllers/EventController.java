package com.ticktac.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.utils.AddEventRequestHandler;
import com.ticktac.utils.EventDetailsRequestHandler;
import com.ticktac.utils.RequestHandler;
import com.ticktac.business.*;
import com.ticktac.data.*;

/**
 * Servlet implementation class EventController
 */
@WebServlet(urlPatterns = { "/addevent","/getevents" ,"/c.jsp","/toeventform.jsp", "/updateEvent", "/deleteEvent", "/eventDetails.htm"})
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> handlersMap = new HashMap<String, Object>();
	private EventDAO events;
	
	@PersistenceContext(unitName="ticktacUP")
	EntityManager em;
	@Resource
	UserTransaction tr;
	
	
    public EventController() {
		handlersMap.put("/addevent", new AddEventRequestHandler());
		handlersMap.put("/eventDetails.htm", new com.ticktac.utils.EventDetailsRequestHandler());
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
		
		}else if(path.equals("/eventDetails.htm")) {
			Object aux = handlersMap.get(path);
			if (aux == null) {
				//Error page.
				response.sendRedirect("notfound.html");
			}
			else {
				RequestHandler rh = (RequestHandler) aux; 
				String sView = rh.handleRequest(request, response);
				request.getRequestDispatcher(sView).forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String viewURL = "notfound.html";
		EventDAO events = new EventDAO();
		
		RequestHandler handler = (RequestHandler) handlersMap.get(path);
		
		if(handler != null)
			viewURL = handler.handleRequest(request, response, em, tr);

		//TODO More handlers
		if(path.equals("/updateEvent") ) {
			
			String title=(String)request.getParameter("title");
			System.out.println(title);
			Event event= events.getInfo(title);
			if(event==null) {
				event=events.getInfo("Band");
			}
			event.setTicketPrice(Float.parseFloat(request.getParameter("newprice")));
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}else if(path.equals("/deleteEvent")) {
			
			String name= (String)request.getParameter("eventName");
			String user=(String)request.getSession().getAttribute("user");
			
			if(events.deleteEvent(name)) {
				
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}			
		}
		
		request.getRequestDispatcher(viewURL).forward(request, response);
	}
}
