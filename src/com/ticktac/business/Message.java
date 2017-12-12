package com.ticktac.business;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private int sender; // ID of the sender
	private int receiver; // ID of the receiver
	private String body; // Content of the message
	
	public Message() {}
	
	public Message(int from, int to, String body) {
		this.sender = from;
		this.receiver = to;
		this.body = body;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int from) {
		this.sender = from;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int to) {
		this.receiver = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
