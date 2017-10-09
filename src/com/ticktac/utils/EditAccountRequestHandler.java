package com.ticktac.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String view = "";
		String name = (String)request.getParameter("name");
		String surname = (String)request.getParameter("surname");
		String oldPassword = (String)request.getParameter("oldPassword");
	  	String password = (String)request.getParameter("password");
	  	String photo = (String)request.getParameter("photo");
	  	
	  	User userBean = (User)request.getSession().getAttribute("userBean");
	  	
	  	if(userBean == null)
	  		view = "notfound.html";
	  	else {
	  		if(userDAO.validateUser(userBean, oldPassword)) {
	  			userBean.updateUser(name, surname, password, photo);
	  			request.getSession().setAttribute("userBean", userBean);
	  			request.setAttribute("successfullEdit", 1);
	  		} else {
	  			request.setAttribute("successfullEdit", 0);
	  		}
  			view = "editaccount.jsp";
	  	}
	  	
		return view;
	}
}
