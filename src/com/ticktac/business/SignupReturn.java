package com.ticktac.business;

import java.io.Serializable;

public class SignupReturn implements Serializable {
	private String view;
	private String newUser;
	
	public SignupReturn() {
	}
	
	public String getView() {
		return this.view;
	}
	public void setView(String view) {
		this.view = view;
	}
	public String getNewUser() {
		return this.newUser;
	}
	public void setNewUser(String newUser) {
		this.newUser = newUser;
	}

}
