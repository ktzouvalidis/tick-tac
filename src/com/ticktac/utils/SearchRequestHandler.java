package com.ticktac.utils;

/*
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.wss.impl.callback.DecryptionKeyCallback.Request;
*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import com.ticktac.data.EventDAO;
import com.ticktac.business.Event;

public class SearchRequestHandler implements RequestHandler{
	
	private EventDAO eventData;
	
	public SearchRequestHandler() {
		// TODO Auto-generated constructor stub
		eventData = new EventDAO();
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String eTitle = null;	
		String sView = "";
	
		eTitle = request.getParameter("searchBar");
		
		if (eTitle == null) {
	  		sView = "index.jsp";
	  	}
		else {
	  		EventDAO ed = new EventDAO();
	  		Event bean = ed.getInfo(eTitle);
	  		if (bean == null) {
	  			sView = "notfound.html";
			}else {
				request.setAttribute("eventBean", bean);
				sView = "searchResults.jsp";
			}
		}
		return sView;
	}
}
