package com.ticktac.utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.sun.glass.ui.Application;
import com.ticktac.business.Event;
import com.ticktac.business.Ticket;
import com.ticktac.business.TicketUser;
import com.ticktac.data.EventDAO;
import com.ticktac.data.TicketDAO;

import org.apache.commons.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;

public class EditEventRequestHandler implements RequestHandler {

	TicketDAO ticketDAO;
	
	public EditEventRequestHandler() {
		ticketDAO = new TicketDAO();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		String view = "notfound.html";

		Event event = new EventDAO().getEvent(Integer.parseInt(request.getParameter("eventID")), em, tr);
		
		if(event != null) {
			request.getSession().setAttribute("eventBean", event);
			List<TicketUser> tickets_list = ticketDAO.getTicketsForEvent(event, em, tr);
			request.setAttribute("ticketuser", tickets_list);
		}
		view = "editevent.jsp";
		
		return view;
	}
}
