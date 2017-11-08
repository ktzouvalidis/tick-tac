package com.ticktac.business;

public class TicketUser {

	private String name;
	private String surname;
	private String date;
	private int amount;
	
	public TicketUser(String name, String surname, String date, int count) {
		this.name = name;
		this.surname = surname;
		this.date = date;
		this.amount = count;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int count) {
		this.amount = count;
	}

}
