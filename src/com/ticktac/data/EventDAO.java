package com.ticktac.data;

import java.util.HashMap;
import java.util.Map;
import com.ticktac.business.Event;

import javax.persistence.EntityManager;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ticktac.business.User;	
public class EventDAO {

	private Map<String , Event> events =new HashMap <String, Event>();
	

	public EventDAO() {}
	
	public Map<String, Event> returnEvents(){
		return events;
	}
	
	public Event getInfo(String title) {
		return (Event) events.get(title);
	}
	public boolean deleteEvent (String title) {
		events.remove(title);
		
		return true;
		
	}
	
	public boolean addEvent(Event event, User user, EntityManager em, UserTransaction tr) {
		try {
			tr.begin();
			em.persist(event);
			user.addEvent(event);
			tr.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try { tr.rollback(); } catch (SystemException se) {	se.printStackTrace(); }
			return false;
		}

		return true;
	}

	public Event getEvent(int eventID, EntityManager em, UserTransaction tr) {
		Event event;
		try {
			tr.begin();
			event = em.find(Event.class, eventID);
			tr.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try { tr.rollback(); } catch (SystemException se) {	se.printStackTrace(); }
			return null;
		}
		return event;
	}
	
	public Event updateEvent(Event event, String title, String date, String photo, String info,
			int ticketPrice, int moreTickets, EntityManager em, UserTransaction tr) {
		try {
			tr.begin();
			if(!em.contains(event)) // Is it being managed?
				event = em.merge(event);
			event.setTitle(title);
			event.setDate(date);
			event.setPhoto(photo);
			event.setInfo(info);
			event.setTicketPrice(ticketPrice);
			event.setTotalTickets(event.getTotalTickets() + moreTickets);
			tr.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try { tr.rollback(); } catch (SystemException se) {	se.printStackTrace(); }
			return null;
		}
		
		return event;
	}

	public boolean deleteEvent(Event event, User user, EntityManager em, UserTransaction tr) {
		try {
			tr.begin();
			if(!em.contains(event)) // Is it being managed?
				event = em.merge(event);
			//user.removeEvent(event); // Throws error code 1048 (user_id in table event cannot be set to null) ...
			em.remove(event);
			tr.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try { tr.rollback(); } catch (SystemException se) {	se.printStackTrace(); }
			return false;
		}

		return true;
	}
}
