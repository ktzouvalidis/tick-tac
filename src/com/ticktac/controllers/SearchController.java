package com.ticktac.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticktac.utils.RequestHandler;
import com.ticktac.utils.SearchRequestHandler;

/**
 * Servlet implementation class SearchController
 */
@WebServlet("/SearchController")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private Map<String, SearchRequestHandler> handlerHash = new HashMap<String, SearchRequestHandler>();
    
    public void init() throws ServletException {

	    // This will read mapping definitions and populate handlerHash (reads URLs)
	    handlerHash.put("/SearchController", new com.ticktac.utils.SearchRequestHandler());
	  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("In the servlet!!!");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Are we in the servlet yet?<br/><br/>");
		
		String sUrl = request.getServletPath();
		out.println(sUrl);
		//Retrieve from the HashMap the instance of the class which implements the logic of the requested url
		Object aux = (SearchRequestHandler) handlerHash.get(sUrl);
		  
		//If no instance is retrieved redirects to error
		if (aux == null) {
			//Error page.
			System.out.println("No object for this url...");
			//response.sendRedirect("index.jsp");
		}
		  
		//Call the method handleRequsest of the instance in order to obtain the url 
		else {
			RequestHandler rh = (RequestHandler) aux; 
			//Dispatch the request to the url obtained
			String sView = rh.handleRequest(request, response);
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
