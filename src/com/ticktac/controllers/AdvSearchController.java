package com.ticktac.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticktac.business.Event;
import com.ticktac.data.EventDAO;
import java.util.Map;
import java.util.HashMap;

/**
 * Servlet implementation class AdvSearchController
 */
@WebServlet("/AdvSearchController")
public class AdvSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String servPath = request.getServletPath();
		  String sName = null;
		  String sView = null;
		  if(servPath.compareTo("/showInfo.html") == 0 || servPath.compareTo("/login.html") == 0) {
			  sName = request.getParameter("name");
		  }
		  if (sName == null) {
			  sView = "entername.jsp";
		  }else {
			  EventDAO ev = new EventDAO();
			  //DataModelBean bean = ds.getInfo(sName);
			  	Map<String , Event> eventMap = new HashMap <String, Event>();	
			 	eventMap = ev.returnEvents();
			 	
			 	for (Map.Entry<String,Event> entry : eventMap.entrySet()){
			 		//HERE use "entry" to set every event that has the category you want 
			 		//into an attribute.
			 		//Then when we are at the adSearchResult.jsp, we'll make all the events
			 		//inside this attribute appear.
			 	}
			  /*
			  if (bean == null) {
				  sView = "sorryNotFound.jsp";
			  }
			  else {
				  request.setAttribute("dataModelBean", bean);
				  sView = "showInfo.jsp";
			  }
			  */
			 	
			  request.getRequestDispatcher(sView).forward(request, response);
		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
