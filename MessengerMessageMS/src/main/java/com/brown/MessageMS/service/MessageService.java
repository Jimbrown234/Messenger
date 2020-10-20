package com.brown.MessageMS.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.brown.MessageMS.dto.MessageDTO;
import com.brown.MessageMS.entity.Message;
import com.brown.MessageMS.repository.MessageRepository;

@Service
public class MessageService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MessageRepository msgRepo;

	
	public void sendMessage(MessageDTO messageDTO) {
		Message msg = messageDTO.createEntity();
		msgRepo.save(msg);
	}

	public List<MessageDTO> getSendMessages(@PathVariable String email){
	
		List<Message> sendMessages = msgRepo.findBySenderEmail(email);
		List<MessageDTO> sendMessagesDTO = new ArrayList<MessageDTO>();
		
		for(Message message:sendMessages) {
			sendMessagesDTO.add(MessageDTO.valueOf(message));
		}
	
		return sendMessagesDTO;
	}

	public List<MessageDTO> getRecMessages(@PathVariable String email){
		
		List<Message> recMessages = msgRepo.findByRecipientEmail(email);
		List<MessageDTO> recMessagesDTO = new ArrayList<MessageDTO>();
		
		for(Message message:recMessages) {
			recMessagesDTO.add(MessageDTO.valueOf(message));
		}
		
		return recMessagesDTO;
	}
}
