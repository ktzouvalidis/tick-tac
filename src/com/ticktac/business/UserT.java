package com.ticktac.business;

import java.util.Vector;
import java.io.Serializable;

public class UserT implements Serializable {
	private String name;
	private String surname;
	private String email;
	private String password;
	private String photo;
	private Vector<Ticket> bought_tickets;
	private Vector<Event> events;
	
	
	public UserT() {}
	
	public UserT(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.photo = "";
		this.bought_tickets= new Vector<Ticket>();
		this.events= new Vector<Event>();
	}
	
	// Getters
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}
	
	/*
	 * For the purpose of emulating the DB
	 */
	public String getPassword() {
		return password;
	}
	
	public String getPhoto() {
		return photo;
	}

	public Vector<Ticket> getBought_tickets() {
		return bought_tickets;
	}

	public Vector<Event> getEvents() {
		return events;
	}
	
	// Setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	 * For the purpose of emulating the DB
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public void setBought_tickets(Vector<Ticket> bought_tickets) {
		this.bought_tickets = bought_tickets;
	}	

	public void setEvents(Vector<Event> events) {
		this.events = events;
	}
	
	public void addTicket(Ticket ticket) {
		bought_tickets.add(ticket);
	}
	
	public void addEvent(Event event) {
		events.add(event);
	}
	
	public void updateUser(String name, String surname, String password, String photo) {
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.photo = photo;
	}
}
