package com.ticktac.data;

import java.util.HashMap;
import java.util.Map;
import com.ticktac.business.Event;

public class EventDAO {
	
	private Map<String , Event> events =new HashMap <String, Event>();
	

	public EventDAO() {
		events.put("Hello",new Event());
		events.put("Hi", new Event());
		events.put("Band ",new Event("Band Concert", "Metal", "<Insert Picture Here>", 50.0, "11/10/17","Madrid","Soon at Madrid!", 500, 0));
		events.put("Band 2",new Event("Band Concert 2", "Rock", "<Insert Picture Here>", 50.0, "11/10/17","Madrid","Soon at Madrid!", 500, 0));
	}
	public Map<String, Event> returnEvents(){
		return events;
	}
	
	public Event getInfo(String title) {
		return (Event) events.get(title);
	}
}
