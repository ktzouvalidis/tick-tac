package com.ticktac.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.transaction.UserTransaction;


import com.ticktac.business.Event;
import com.ticktac.business.User;
import com.ticktac.controllers.EventController;
import com.ticktac.data.EventDAO;

public class UpdateEventRequestHandler implements RequestHandler {
	EventDAO eventDAO;
	private final static Logger LOGGER = Logger.getLogger(EventController.class.getCanonicalName());
	
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

	        if(cancellation==null){
	          String title = request.getParameter("title");
	          String date = request.getParameter("date");
	          String photo = request.getParameter("photo"); // Still gets null value...
	          String info= request.getParameter("info");
	          int ticketPrice = Integer.parseInt(request.getParameter("ticketPrice"));
	          int moreTickets = Integer.parseInt(request.getParameter("moreTickets"));
	
	            if(eventBean != null) {
	            	//editevent with URL will not load the next page properly if these 3 lines are uncommented.
	            	//if(photo != null && !photo.isEmpty()) {
	            	// uploadPhoto(request.getPart("photo"), response.getWriter());
	            	// }
	              Event updatedEvent = eventDAO.updateEvent(eventBean, title, date, photo, info, ticketPrice, moreTickets, em, tr);
	              if(updatedEvent != null) {
	                request.getSession().setAttribute("eventBean", updatedEvent);
	                //Checking to see if the event's state needs to be updated.
	                eventDAO.editEventStatus(updatedEvent, false, em, tr);
	              }else
	                request.setAttribute("successfullEdit", 0);
	
	              view = "editevent.jsp";
	            }
	        }else{
	          eventDAO.editEventStatus(eventBean, true, em, tr); //boolean parameter = true: Cancel Event.
	          view = "myevents.jsp";
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
	

	private boolean uploadPhoto(Part photoPart, PrintWriter writer) {
		final String fileName = getFileName(photoPart);
		
		OutputStream out = null;
		InputStream photoContent = null;
		// Copied from https://docs.oracle.com/javaee/7/tutorial/servlets016.htm
		// TODO - Use Apache's commons UploadFile jar
		try {
			out = new FileOutputStream(new File(PHOTO_DIRECTORY + File.separator + fileName));
			photoContent = photoPart.getInputStream();
			
			int read = 0;
			final byte[] bytes = new byte[MAX_MEMORY_SIZE];
			
			while((read = photoContent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			System.out.println("New file " + fileName + " created at " + PHOTO_DIRECTORY);
			LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
	                new Object[]{fileName, PHOTO_DIRECTORY});
		}catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}",
	                new Object[]{e.getMessage()});
		} finally {
			try {
				if (out != null)
		            out.close();
		        if (photoContent != null)
		        	photoContent.close();
		        if (writer != null)
		            writer.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	// Get the file name from the given part - Copied from https://docs.oracle.com/javaee/7/tutorial/servlets016.htm
	private String getFileName(final Part photoPart) {
		final String partHeader = photoPart.getHeader("content-disposition");
		LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
		for(String content : photoPart.getHeader("content-disposition").split(";")) {
			if(content.trim().startsWith("filename"))
				return content.substring(content.indexOf('=') + 1).replace("\"", "");
		}
		
		return null;
	}
}
