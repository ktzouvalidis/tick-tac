package com.ticktac.business;

import java.io.Serializable;

public class BankReturn implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int transactionCode;
	private int httpCode;
	
	public int getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}
	public int getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(int httpCode) {
		this.httpCode = httpCode;
	}
	
	@Override
	public String toString() {
		return "BankReturn [transactionCode=" + transactionCode + ", httpCode=" + httpCode + "]";
	}
	public BankReturn(int transactionCode, int httpCode) {
		super();
		this.transactionCode = transactionCode;
		this.httpCode = httpCode;
	}
	public BankReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
