package com.ticktac.controllers;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.Event;
import com.ticktac.data.EventDAO;
import com.ticktac.utils.AddEventRequestHandler;
import com.ticktac.utils.EditEventRequestHandler;
import com.ticktac.utils.UpdateEventRequestHandler;
import com.ticktac.utils.RequestHandler;
import com.ticktac.utils.EventDetailsRequestHandler;
import com.ticktac.utils.RandomEventsRequestHandler;

/**
 * Servlet implementation class EventController
 */
@WebServlet(urlPatterns = { "/addevent", "/getevents" ,"/myevents", "/editevent", "/updateevent", "/deleteEvent", "/eventdetails", "/index.jsp"})
@MultipartConfig // Indicates that the servlet expects requests to be made using the multipart/form-data MIME type
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> handlersMap = new HashMap<String, Object>();
	
	@PersistenceContext(unitName="ticktacUP")
	EntityManager em;
	@Resource
	UserTransaction tr;
	
    public EventController() {
		handlersMap.put("/addevent", new AddEventRequestHandler());
		handlersMap.put("/updateevent", new UpdateEventRequestHandler());
		handlersMap.put("/editevent", new EditEventRequestHandler());
		handlersMap.put("/index.jsp", new RandomEventsRequestHandler());
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		
		if(path.equals("/addevent"))
			request.getRequestDispatcher("addevent.jsp").forward(request, response);
		else if(path.equals("/myevents"))
			request.getRequestDispatcher("myevents.jsp").forward(request, response);
		else if(path.equals("/eventdetails")) {
			Event event = new EventDAO().getEvent(Integer.parseInt(request.getParameter("eventID")), em, tr);
			if(event != null) {
				request.getSession().setAttribute("eventBean", event);
				request.getRequestDispatcher("eventdetails.jsp").forward(request, response);
			}
		}
		else
			doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		RequestHandler handler = (RequestHandler) handlersMap.get(path);
		String viewURL = "notfound.html";
		
		if(handler != null)
			viewURL = handler.handleRequest(request, response, em, tr);
		
		request.getRequestDispatcher(viewURL).forward(request, response);

	}
}
