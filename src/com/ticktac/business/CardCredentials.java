package com.ticktac.business;

import java.io.Serializable;

public class CardCredentials implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int cardNumber;
	private int cv2Number;
	private int expireMonth;
	private int expireYear;
	

	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
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
	
	@Override
	public String toString() {
		return "CardCredentials [cardNumber=" + cardNumber + ", cv2Number=" + cv2Number + ", expireMonth=" + expireMonth
				+ ", expireYear=" + expireYear + "]";
	}
	
	public CardCredentials(int cardNumber, int cv2Number, int expireMonth, int expireYear) {
		super();
		this.cardNumber = cardNumber;
		this.cv2Number = cv2Number;
		this.expireMonth = expireMonth;
		this.expireYear = expireYear;
	}
	
	public CardCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
