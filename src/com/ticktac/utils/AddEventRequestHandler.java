package com.ticktac.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticktac.data.EventDAO;

public class AddEventRequestHandler implements RequestHandler {
	EventDAO eventDAO;
	
	public AddEventRequestHandler() {
		eventDAO = new EventDAO();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		String title = (String)request.getParameter("title");
		String date = (String)request.getParameter("date");
		String place = (String)request.getParameter("place");
		int tickets = Integer.parseInt(request.getParameter("tickets"));
		double price = Double.parseDouble(request.getParameter("price"));
		String category = (String)request.getParameter("category");
		String info = (String)request.getParameter("info");
		
		if(category.isEmpty() || info.isEmpty())
			view = "addevent.jsp";
		else {
			if(eventDAO.addEvent(title, date, place, tickets, price, category, info))
				request.setAttribute("eventExists", 0);
			else
				request.setAttribute("eventExists", 1);
				
			view = "addevent.jsp";
		}
		
		return view;
	}

}
