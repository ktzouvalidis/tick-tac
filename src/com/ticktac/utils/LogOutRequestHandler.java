package com.ticktac.utils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ticktac.data.UserDAO;

public class LogOutRequestHandler implements RequestHandler {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("user", null);
		return "index.jsp";
	}

}
