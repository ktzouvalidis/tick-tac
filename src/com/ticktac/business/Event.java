package com.ticktac.business;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import com.ticktac.utils.Color;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String category;
	private Date date;
	private String info;
	private String photo;
	private int soldTickets;
	private float ticketPrice;
	private String title;
	private int totalTickets;
	private String venue;
	private User user;
	private List<Ticket> tickets;
	
	//For the view - Can't make it work
	private String color;

	public Event() {}

	public Event(String title, String category, String venue, String date, String info, float ticketPrice,
			int totalTickets, User user, String photo) {
		this.title = title;
		this.category = category;
		this.venue = venue;
		// Managing the date input
		String[] dateNtime = date.split("T");
		String datetime = dateNtime[0] + " " + dateNtime[1] + ":00";
		try { this.date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(datetime); }catch(Exception e) { e.printStackTrace(); }
		this.info = info;
		this.ticketPrice = ticketPrice;
		this.totalTickets = totalTickets;
		this.user = user;
		this.photo = photo;
		
		//Manage background color - Can't make it work
		if(category == "Concert")
			this.color = Color.CONCERT.getColor();
		else if(category == "Festival")
			this.color = Color.FESTIVAL.getColor();
		else if(category == "Expedition")
			this.color = Color.EXPEDITION.getColor();
		else
			this.color = Color.THEATER.getColor();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setDate(String date) {
		try { this.date = new SimpleDateFormat("yyyy-MM-dd").parse(date); }catch(Exception e) { e.printStackTrace(); }
	}


	public String getInfo() {
		return this.info;
	}

	public void setInfo(String info) {
		this.info = info;
	}


	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public int getSoldTickets() {
		return this.soldTickets;
	}

	public void setSoldTickets(int soldTickets) {
		this.soldTickets = soldTickets;
	}


	public float getTicketPrice() {
		return this.ticketPrice;
	}

	public void setTicketPrice(float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}


	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public int getTotalTickets() {
		return this.totalTickets;
	}

	public void setTotalTickets(int totalTickets) {
		this.totalTickets = totalTickets;
	}


	public String getVenue() {
		return this.venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	//bi-directional many-to-one association to Ticket
	@OneToMany(mappedBy="eventBean")
	public List<Ticket> getTickets() {
		return this.tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public Ticket addTicket(Ticket ticket) {
		getTickets().add(ticket);
		ticket.setEventBean(this);
		
		return ticket;
	}

	public Ticket removeTicket(Ticket ticket) {
		getTickets().remove(ticket);
		ticket.setEventBean(null);

		return ticket;
	}
	
	//For the view - Can't make it work
	public String getColor() {
		return color;
	}
}