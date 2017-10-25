package com.ticktac.utils;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import com.ticktac.business.User;
import com.ticktac.data.UserDAO;

public class EditAccountRequestHandler implements RequestHandler {
	UserDAO userDAO;
	
	public EditAccountRequestHandler() {
		userDAO = new UserDAO();
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		return null;
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		String view = "";
		String name = (String)request.getParameter("name");
		String surname = (String)request.getParameter("surname");
		String oldPassword = (String)request.getParameter("oldPassword");
	  	String password = (String)request.getParameter("password");
	  	String photo = (String)request.getParameter("photo");
	  	String deletion = (String)request.getParameter("deletion");
	  	
	  	User userBean = (User)request.getSession().getAttribute("userBean");
	  	
	  	if(deletion == null) {
		  	if(userBean == null)
		  		view = "notfound.html";
		  	else {
		  		if(userDAO.validateUser(userBean, oldPassword)) {
		  			User updatedUser = userDAO.updateUser(userBean, name, surname, password, photo, em, tr);
		  			if(updatedUser != null)
		  				request.getSession().setAttribute("userBean", updatedUser);
		  			else
			  			request.setAttribute("successfullEdit", 0);
		  		} else {
		  			request.setAttribute("successfullEdit", 0);
		  		}
	  			view = "editaccount.jsp";
		  	}
	  	} else {
	  		if(userDAO.userHasTickets(userBean)) {
	  			request.setAttribute("successfullEdit", -1);
	  			view = "editaccount.jsp";
	  		} else {
		  		userDAO.removeUser(userBean, em, tr);
		  		request.getSession().removeAttribute("userBean");
	  			view = "index.jsp";	  			
	  		}
	  	}
	  	
		return view;
	}
	
	private User updateUser(String n, String sn, String p, String ph) {
		User u = new User();
		u.setName(n);
		u.setSurname(sn);
		u.setPassword(p);
		u.setPhoto(ph);
		
		return u;
	}

}
