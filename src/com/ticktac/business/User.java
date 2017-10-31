package com.ticktac.business;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String name;
	private String password;
	private String photo;
	private String surname;
	private List<Event> events;
	private List<Ticket> tickets;

	public User() {}

	public User(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval=true)
	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setUser(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setUser(null);

		return event;
	}


	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="user")
	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setUser(this);

		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setUser(null);

		return ticket;
	}

}