package com.ticktac.business;

import java.io.Serializable;
import java.math.BigInteger;

public class CreditCard implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cardNumber;
	private int cv2Number;
	private int expireMonth;
	private int expireYear;
	private float balance;
	

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
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "CardCredentials [cardNumber=" + cardNumber + ", cv2Number=" + cv2Number + ", expireMonth=" + expireMonth
				+ ", expireYear=" + expireYear + "]";
	}
	
	public CreditCard(String cardNumber, int cv2Number, int expireMonth, int expireYear, float balance) {
		super();
		this.cardNumber = cardNumber;
		this.cv2Number = cv2Number;
		this.expireMonth = expireMonth;
		this.expireYear = expireYear;
		this.balance = balance;
	}
	
	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
