package com.ticktac.business;

import java.io.Serializable;

public class BankReturn implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int transactionCode;
	
	public int getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(int transactionCode) {
		this.transactionCode = transactionCode;
	}

	
	@Override
	public String toString() {
		return "BankReturn [transactionCode=" + transactionCode + "]";
	}
	public BankReturn(int transactionCode) {
		super();
		this.transactionCode = transactionCode;
	}
	public BankReturn() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
