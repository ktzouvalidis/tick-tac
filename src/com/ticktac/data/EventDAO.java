package com.ticktac.data;

import java.util.HashMap;
import java.util.Map;
import com.ticktac.business.Event;
import java.util.Vector;

import javax.persistence.EntityManager;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import com.ticktac.business.Ticket;	
public class EventDAO {

	private Map<String , Event> events =new HashMap <String, Event>();
	

	public EventDAO() {
		/*events.put("Hello",new Event());
		events.put("Hi", new Event());
		events.put("Band",new Event("Band Concert", "Rock", "images/Metallica.png", 50.0, "2017-10-11","Madrid","Placeholder description text.", 500, new Vector<Ticket>()));
		events.put("Band 2",new Event("Band Concert 2", "Rock", "images/PinkFloyd.png", 50.0, "2017-10-11","Madrid","Placeholder description text.", 500, new Vector<Ticket>()));
		events.put("Band 3",new Event("Band Concert 3", "Metal", "<Insert Image Here>", 50.0, "2017-10-25","Barcelona","Placeholder description text.", 500, new Vector<Ticket>()));*/
	}
	
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
	
	public boolean addEvent(Event event, EntityManager em, UserTransaction tr) {
		try {
			tr.begin();
			em.persist(event);
			tr.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try { tr.rollback(); } catch (SystemException se) {	se.printStackTrace(); }
			return false;
		}

		return true;
	}
}
