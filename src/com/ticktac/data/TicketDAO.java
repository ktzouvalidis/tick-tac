package com.ticktac.data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ticktac.business.Event;
import com.ticktac.business.Ticket;
import com.ticktac.business.TicketUser;
import com.ticktac.business.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Status;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class TicketDAO {
	private Map<String , Ticket> tickets =new HashMap <String, Ticket>();
	
	public TicketDAO() {}
	
	public Map<String, Ticket> returnTickets(){
		return tickets;
	}
	
	public boolean addTicket(Ticket ticket, User user, Event event, EntityManager em, UserTransaction tr) {
		try {
			tr.begin();
			em.persist(ticket);
			tr.commit();
			user.addTicket(ticket);
			event.addTicket(ticket);
		} catch(Exception e) {
			e.printStackTrace();
			try {
				if (tr.getStatus()==Status.STATUS_ACTIVE)
					tr.rollback();
			} catch (Exception se) {se.printStackTrace(); return false;}
			return false;
		}

		return true;
	}
	
	//Has not been tested yet:
	public Ticket getEvent(int ticketID, EntityManager em, UserTransaction tr) {
		Ticket ticket;
		try {
			tr.begin();
			ticket = em.find(Ticket.class, ticketID);
			tr.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try { tr.rollback(); } catch (SystemException se) {	se.printStackTrace(); }
			return null;
		}
		return ticket;
	}
	
	public List<TicketUser> getTicketsForEvent(Event event, EntityManager em, UserTransaction tr) {
		String prep = "SELECT u.name, u.surname, t.dateOfSale, count(u.id) as amount FROM user AS u, "
					+ "ticket AS t WHERE u.id = t.buyer AND t.event=" + event.getId() + " GROUP BY u.id"; 
		try {
			Query q = em.createNativeQuery(prep);
			//q.setParameter("category", event.getId());
			
			List<Object[]> results = q.getResultList();
			List<TicketUser> tickets = new ArrayList<>(results.size());
			for(Object[] result : results)
				tickets.add(new TicketUser((String)result[0], (String)result[1], new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result[2]), ((Long)result[3]).intValue()));
			return tickets;
		}  catch(Exception e) {
			e.printStackTrace();
			try { tr.rollback(); } catch (SystemException se) {	se.printStackTrace(); }
			return null;
		}
	}
}
