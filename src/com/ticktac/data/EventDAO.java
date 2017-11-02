package com.ticktac.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ticktac.business.Event;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Status;
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
	
	public List<Event> searchEvents(String title, EntityManager em, UserTransaction tr) {
		String prep = "SELECT e FROM Event e WHERE e.title LIKE :title";
		try {
			TypedQuery<Event> q = em.createQuery(prep, Event.class);
			q.setParameter("title", "%" + title + "%"); // % needed for the LIKE statement in the query
			
			List<Event> events = q.getResultList();
			return events;
		} catch(Exception e) {
			e.printStackTrace();
			try {
				if (tr.getStatus()==Status.STATUS_ACTIVE)
					tr.rollback();
			} catch (Exception se) {se.printStackTrace(); return null;}
			return null;
		}
	}
	
	public List<Event> searchEvents(String category, String venue, String date, EntityManager em, UserTransaction tr) {
		String prep;
		if(date.isEmpty() || date == "")
			prep = "SELECT e FROM Event e WHERE e.category=:category AND e.venue LIKE :venue";
		else
			prep = "SELECT e FROM Event e WHERE e.category=:category AND e.venue LIKE :venue AND e.date LIKE :date";
		try {
			TypedQuery<Event> q = em.createQuery(prep, Event.class);
			q.setParameter("category", category);
			q.setParameter("venue", "%" + venue + "%");
			if(!date.isEmpty() && date != "")
				q.setParameter("date", "%" + date + "%");
			
			List<Event> events = q.getResultList();
			return events;
		} catch(Exception e) {
			e.printStackTrace();
			try {
				if (tr.getStatus()==Status.STATUS_ACTIVE)
					tr.rollback();
			} catch (Exception se) {se.printStackTrace(); return null;}
			return null;
		}
	}
	
	public boolean addEvent(Event event, User user, EntityManager em, UserTransaction tr) {
		try {
			tr.begin();
			em.persist(event);
			tr.commit();
			user.addEvent(event);
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
			e.printStackTrace();try {
				if (tr.getStatus()==Status.STATUS_ACTIVE)
					tr.rollback();
			} catch (Exception se) {se.printStackTrace(); return null;}
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
