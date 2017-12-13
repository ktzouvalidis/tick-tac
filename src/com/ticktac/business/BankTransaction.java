package com.ticktac.business;

import java.io.Serializable;
import java.util.Date;

public class BankTransaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String card_number;
	private int cv2_number;
	private int expire_month;
	private int expire_year;
	private int tickets_bought;
	private int ticket_price;
	private int total_amount;
	private String date;
	

	public String getCardNumber() {
		return card_number;
	}
	public void setCardNumber(String cardNumber) {
		this.card_number = cardNumber;
	}
	public int getCv2Number() {
		return cv2_number;
	}
	public void setCv2Number(int cv2Number) {
		this.cv2_number = cv2Number;
	}
	public int getExpireMonth() {
		return expire_month;
	}
	public void setExpireMonth(int expireMonth) {
		this.expire_month = expireMonth;
	}
	public int getExpireYear() {
		return expire_year;
	}
	public void setExpireYear(int expireYear) {
		this.expire_year = expireYear;
	}
	public int getTicketsBought() {
		return tickets_bought;
	}
	public void setTicketsBought(int ticketsBought) {
		this.tickets_bought = ticketsBought;
	}
	public int getTicketPrice() {
		return ticket_price;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticket_price = ticketPrice;
	}
	public int getTotalAmount() {
		return this.total_amount;
	}
	public void setTotalAmount(int totalAmount) {
		this.total_amount = totalAmount;
	}
	public String getDate() {
		return this.date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "CardCredentials [cardNumber=" + card_number + ", cv2Number=" + cv2_number + ", expireMonth=" + expire_month
				+ ", expireYear=" + expire_year + "]";
	}

	public BankTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
