package com.ticktac.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

}
