package com.ticktac.business;

import java.io.Serializable;

public class BankReturn implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String transactionCode;
	
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	
	@Override
	public String toString() {
		return "BankReturn [transactionCode=" + transactionCode + "]";
	}
	public BankReturn(String transactionCode) {
		super();
		this.transactionCode = transactionCode;
	}
	public BankReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
