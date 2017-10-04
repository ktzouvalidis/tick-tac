package com.ticktac.data;

import java.util.HashMap;
import java.util.Map;
import com.ticktac.business.Event;

public class EventDAO {

	private Map<String , Event> events =new HashMap <String, Event>();

	public EventDAO() {
		events.put("Hello",new Event());
		events.put("Hi", new Event());
		
	}
	public Map<String, Event> returnEvents(){
		return events;
	}
	
	
}
