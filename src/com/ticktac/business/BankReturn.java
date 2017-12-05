package com.ticktac.business;

import java.io.Serializable;

public class BankReturn implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int transactionCode;
	private String httpCode;
	
	public int getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getHttpCode() {
		return httpCode;
	}
	public void setHttpCode(String httpCode) {
		this.httpCode = httpCode;
	}
	
	@Override
	public String toString() {
		return "BankReturn [transactionCode=" + transactionCode + ", httpCode=" + httpCode + "]";
	}
	public BankReturn(int transactionCode, String httpCode) {
		super();
		this.transactionCode = transactionCode;
		this.httpCode = httpCode;
	}
	public BankReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
