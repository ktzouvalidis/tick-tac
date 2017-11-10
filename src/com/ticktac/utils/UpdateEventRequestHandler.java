package com.ticktac.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.Event;
import com.ticktac.business.User;
import com.ticktac.data.EventDAO;

public class UpdateEventRequestHandler implements RequestHandler {
	EventDAO eventDAO;
	
	private final String PHOTO_DIRECTORY = "/images/";
	private final int MAX_MEMORY_SIZE = 2048 * 2048 * 2;
	private final int MAX_REQUEST_SIZE = 2048 * 2048;
	
	public UpdateEventRequestHandler() {
		eventDAO = new EventDAO();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException{
		String view = "notfound.html";
		
		String cancellation = (String)request.getParameter("cancellation");
	  	String deletion = (String)request.getParameter("deletion");
	  	
	  	Event eventBean = (Event)request.getSession().getAttribute("eventBean");
	  	User userBean = (User)request.getSession().getAttribute("userBean");
	  	if(deletion == null) {
	  		if (cancellation == null) {
				String title = request.getParameter("title");
				String date = request.getParameter("date");
				String photo = request.getParameter("photo");
				String info= request.getParameter("info");
				int ticketPrice = Integer.parseInt(request.getParameter("ticketPrice"));
				int moreTickets = Integer.parseInt(request.getParameter("moreTickets"));
			  	
			  	if(eventBean != null) {
				  		if(photo != null && !photo.isEmpty()) {
				  			photo = PHOTO_DIRECTORY + photo;
				  			uploadPhoto(photo, response.getWriter());
				  		}
				  		Event updatedEvent = eventDAO.updateEvent(eventBean, title, date, photo, info, ticketPrice, moreTickets, em, tr);
				  		new EventDAO().editEventStatus(updatedEvent, false, em, tr); //boolean parameter checks if event is to be Cancelled.
				  		if(updatedEvent != null) 
				  			request.getSession().setAttribute("eventBean", updatedEvent);
			  			else
				  			request.setAttribute("successfullEdit", 0);
			  			view = "editevent.jsp";
			  	}
	  		}else {
	  			eventDAO.editEventStatus(eventBean, true, em, tr); //boolean parameter = true: Cancel Event.
	  			//eventBean.setStatus("Cancelled");
	  			view = "editevent.jsp";
	  		}
	  	} else {
	  		if(eventDAO.deleteEvent(eventBean, userBean, em, tr)) {
	  			request.setAttribute("successfullDeletion", 0);
	  			view = "myevents.jsp";
	  		} else {
	  			request.setAttribute("failedDeletion", 0);
	  			view = "editevent.jsp";
	  		}
	  	}
		
		return view;
	}
	

	private boolean uploadPhoto(String path, PrintWriter writer) {
		OutputStream out = null;
		InputStream photoContent = null;
		// TODO - Use Apache's commons UploadFile jar
		try {
			out = new FileOutputStream(new File(path));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
