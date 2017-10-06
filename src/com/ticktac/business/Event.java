package com.ticktac.business;

//import java.util.Vector;

import java.io.Serializable;

public class Event implements Serializable {
	
	private String title;
	//category type should be "enum", I don't know what it is in Java
	private String category;
	//image type in Java?
	private String picture;
	private double ticket_price;
	private String date;
	private String venue;
	private String informaton;
	private int total_tickets;
	//private Vector<Ticket> sold_tickets;
	private int sold_tickets;
	
	public Event() {
		//for the tests
		this.title="concert";
	}
	
	public Event(String title, String category, String picture, double ticket_price, String date, String venue, String information, int total_ticket, int soldTickets){
		this.title = title;
		this.category = category;
		this.picture = picture;
		this.ticket_price = ticket_price;
		this.date = date;
		this.venue = venue;
		this.informaton = information;
		this.total_tickets = total_ticket;
		this.sold_tickets = soldTickets;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public double getTicket_price() {
		return ticket_price;
	}

	public void setTicket_price(double ticket_price) {
		this.ticket_price = ticket_price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getInformaton() {
		return informaton;
	}

	public void setInformaton(String informaton) {
		this.informaton = informaton;
	}

	public int getTotal_tickets() {
		return total_tickets;
	}

	public void setTotal_tickets(int total_tickets) {
		this.total_tickets = total_tickets;
	}

	public int getSold_tickets() {
		return sold_tickets;
	}
	
	public void setSold_tickets(int sold_tickets) {
		this.sold_tickets = sold_tickets;
	}
	
	/*
	public Vector<Ticket> getSold_tickets() {
		return sold_tickets;
	}

	public void setSold_tickets(Vector<Ticket> sold_tickets) {
		this.sold_tickets = sold_tickets;
	}
	*/

}
