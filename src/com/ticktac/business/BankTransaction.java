package com.ticktac.business;

import java.io.Serializable;

public class BankTransaction implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cardNumber;
	private int cv2Number;
	private int expireMonth;
	private int expireYear;
	private int ticketsBought;
	private int ticketPrice;
	

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public int getCv2Number() {
		return cv2Number;
	}
	public void setCv2Number(int cv2Number) {
		this.cv2Number = cv2Number;
	}
	public int getExpireMonth() {
		return expireMonth;
	}
	public void setExpireMonth(int expireMonth) {
		this.expireMonth = expireMonth;
	}
	public int getExpireYear() {
		return expireYear;
	}
	public void setExpireYear(int expireYear) {
		this.expireYear = expireYear;
	}
	public int getTicketsBought() {
		return ticketsBought;
	}
	public void setTicketsBought(int ticketsBought) {
		this.ticketsBought = ticketsBought;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
	@Override
	public String toString() {
		return "CardCredentials [cardNumber=" + cardNumber + ", cv2Number=" + cv2Number + ", expireMonth=" + expireMonth
				+ ", expireYear=" + expireYear + "]";
	}
	public BankTransaction(String cardNumber, int cv2Number, int expireMonth, int expireYear, int ticketsBought, int ticketPrice) {
		super();
		this.cardNumber = cardNumber;
		this.cv2Number = cv2Number;
		this.expireMonth = expireMonth;
		this.expireYear = expireYear;
		this.ticketsBought = ticketsBought;
		this.ticketPrice = ticketPrice;
	}
	public BankTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
