package com.ticktac.utils;

import java.io.IOException;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Handles requests about the Messaging System
 */
public interface MessageRequestHandler extends RequestHandler {
	
	String handleRequest(HttpServletRequest request,
			HttpServletResponse response, ConnectionFactory cf, Queue queue)
					throws ServletException, IOException;
}
