package com.ticktac.utils;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import com.ticktac.business.Event;
import com.ticktac.business.Ticket;
import com.ticktac.data.EventDAO;
import com.ticktac.data.TicketDAO;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

public class EventDetailsRequestHandler implements RequestHandler{
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return null;
	}

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, EntityManager em,
			UserTransaction tr) throws ServletException, IOException {
		return null;
	}
}
