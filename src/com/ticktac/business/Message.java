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
	private String senderName; // Sender's name - value of 'Administrator' if the sender is the Administrator
	private int receiver; // ID of the receiver
	private String body; // Content of the message
	
	public Message() {}
	
	public Message(int sender, String senderName, int receiver, String body) {
		this.sender = sender;
		this.senderName = senderName;
		this.receiver = receiver;
		this.body = body;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int from) {
		this.sender = from;
	}
	
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
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
