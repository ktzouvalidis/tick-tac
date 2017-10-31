package com.ticktac.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.Event;
import com.ticktac.data.EventDAO;
import com.ticktac.utils.AddEventRequestHandler;
import com.ticktac.utils.EditEventRequestHandler;
import com.ticktac.utils.RequestHandler;

/**
 * Servlet implementation class EventController
 */
@WebServlet(urlPatterns = { "/addevent", "/getevents" ,"/myevents", "/editevent", "/updateevent", "/deleteEvent", "/eventDetails.htm"})
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> handlersMap = new HashMap<String, Object>();
	
	@PersistenceContext(unitName="ticktacUP")
	EntityManager em;
	@Resource
	UserTransaction tr;
	
    public EventController() {
		handlersMap.put("/addevent", new AddEventRequestHandler());
		handlersMap.put("/updateevent", new EditEventRequestHandler());
		handlersMap.put("/eventDetails.htm", new com.ticktac.utils.EventDetailsRequestHandler());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		System.out.println(path);
		
		if(path.equals("/addevent"))
			request.getRequestDispatcher("addevent.jsp").forward(request, response);
		else if(path.equals("/myevents"))
			request.getRequestDispatcher("myevents.jsp").forward(request, response);
		else if(path.equals("/eventDetails.htm")) {
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
		
		// This needs to be first. Without a handler!
		if(path.equals("/editevent")) {
			// If it finds the event by id - it SHOULD find it - forward to the Edit Event page.
			Event event = new EventDAO().getEvent(Integer.parseInt(request.getParameter("eventID")), em, tr);
			if(event != null) {
				request.getSession().setAttribute("eventBean", event);
				request.getRequestDispatcher("editevent.jsp").forward(request, response);
			}
		}else {
			// Get the help of the handlers
			RequestHandler handler = (RequestHandler) handlersMap.get(path);
			String viewURL = "notfound.html";
			
			if(handler != null)
				viewURL = handler.handleRequest(request, response, em, tr);
			
			request.getRequestDispatcher(viewURL).forward(request, response);
		}
	}
}
