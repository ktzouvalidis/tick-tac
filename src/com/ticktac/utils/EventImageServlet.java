package com.ticktac.utils;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticktac.business.Event;
import com.ticktac.data.EventDAO;

/**
 * Servlet implementation class EventImageServlet
 */
@WebServlet("/events/image.html")
public class EventImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EventDAO evDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		/*
		Event ev = (Event) request.getSession().getAttribute("eventBean");
		int id = ev.getId();
		System.out.println("CAN ANYONE HEAR ME? " + id) ;
	//	byte[] image = evDAO.loadEventImage(id);
		response.setContentType("image/jpg");
		ServletOutputStream oStream = response.getOutputStream();
		//oStream.write(image);
		oStream.close();
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	}

}
