package com.brown.MessageMS.dto;

import com.brown.MessageMS.entity.Message;

public class MessageDTO {

	long msgId;
	
	UserDTO sender;
	
	UserDTO recipient;
	
	String message;
	
	public MessageDTO() {
		super();
	}
	
	public long getMsgId() {
		return msgId;
	}

	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserDTO getSender() {
		return sender;
	}

	public void setSender(UserDTO sender) {
		this.sender = sender;
	}

	public UserDTO getRecipient() {
		return recipient;
	}

	public void setRecipient(UserDTO recipient) {
		this.recipient = recipient;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MessageDTO[msgId="+msgId+", sender="+sender.getName()+", recipient="+recipient.getName()+", Message="+message+"]";
	}

	public static MessageDTO valueOf(Message msg) {
		MessageDTO  messageDTO = new MessageDTO();
		messageDTO.setMessage(msg.getMessage());
		UserDTO sender = new UserDTO();
		sender.setEmail(msg.getSenderEmail());
		messageDTO.setSender(sender);
		UserDTO recipient = new UserDTO();
		recipient.setEmail(msg.getRecipientEmail());
		messageDTO.setRecipient(recipient);
		messageDTO.setMsgId(msg.getMsgId());
		return messageDTO;
	}
	
	public Message createEntity() {
		Message msg = new Message();
		msg.setMessage(this.message);
		msg.setRecipientEmail(this.recipient.getEmail());
		msg.setSenderEmail(this.sender.getEmail());
		return msg; 
	}

}
