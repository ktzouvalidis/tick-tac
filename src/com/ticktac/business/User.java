package com.ticktac.business;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String surname;
	private String email;
	private String password;
	
	public User() {}
	
	public User(String name, String surname, String email, String password) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}
	
	/*
	 * For the purpose of emulating the DB
	 */
	public String getPassword() {
		return password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/*
	 * For the purpose of emulating the DB
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
