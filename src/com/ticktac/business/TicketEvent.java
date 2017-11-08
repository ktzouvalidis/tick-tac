package com.ticktac.business;

public class TicketEvent {
	private int code;
	private String date;
	private String title;
	private float price;
	
	public TicketEvent(int code, String date, String title, float price) {
		this.code = code;
		this.date = date;
		this.title = title;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}
