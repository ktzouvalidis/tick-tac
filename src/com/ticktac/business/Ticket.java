package com.ticktac.business;

import java.io.Serializable;

public class Ticket implements Serializable {

	private String id;
	private String date;
	private String venue;
	private String date_of_sale;
	private String buyer_name;
	private String event_title;
	
	
	
	public Ticket() {
	}



	public Ticket(String id, String date, String venue, String date_of_sale, String buyer_name, String event_title) {
		
		this.id = id;
		this.date = date;
		this.venue = venue;
		this.date_of_sale = date_of_sale;
		this.buyer_name = buyer_name;
		this.event_title = event_title;
	}



	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}



	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}



	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}



	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}



	/**
	 * @return the date_of_sale
	 */
	public String getDate_of_sale() {
		return date_of_sale;
	}



	/**
	 * @param date_of_sale the date_of_sale to set
	 */
	public void setDate_of_sale(String date_of_sale) {
		this.date_of_sale = date_of_sale;
	}



	/**
	 * @return the buyer_name
	 */
	public String getBuyer_name() {
		return buyer_name;
	}



	/**
	 * @param buyer_name the buyer_name to set
	 */
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}



	/**
	 * @return the event_title
	 */
	public String getEvent_title() {
		return event_title;
	}



	/**
	 * @param event_title the event_title to set
	 */
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	
	
	
}
