package com.brown.MessageMS.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "MESSAGES")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer msgId;
	
	@Column(name = "SENDER_EMAIL", nullable = false)
	String senderEmail;
	
	@Column(name = "RECIPIENT_EMAIL", nullable = false)
	String recipientEmail;
	
	@Column(name = "MESSAGE")
	String message;

	public Message() {
		super();
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getRecipientEmail() {
		return recipientEmail;
	}

	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMsgId() {
		return msgId;
	}
	
}
