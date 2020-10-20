package com.brown.MessageMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.brown.MessageMS.dto.MessageDTO;
import com.brown.MessageMS.dto.UserDTO;
import com.brown.MessageMS.service.MessageService;

@RestController
@CrossOrigin
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@Value("${user.uri}")
	String userUri;
	
	
	@GetMapping(value = "/sentMail/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MessageDTO> getSentMessages(@PathVariable String email){
		
		List<MessageDTO> msgList = messageService.getSendMessages(email);
		
		for(MessageDTO messageDTO: msgList) {
			UserDTO recipient = new RestTemplate().getForObject(userUri+messageDTO.getRecipient().getEmail(), UserDTO.class);
			messageDTO.setRecipient(recipient);
		}
		
		return msgList;
	}

	@GetMapping(value = "/inbox/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<MessageDTO> getRecMessages(@PathVariable String email){
		
	
		List<MessageDTO> msgList = messageService.getRecMessages(email);
		
		for(MessageDTO messageDTO: msgList) {
			
			UserDTO sender = new RestTemplate().getForObject(userUri+messageDTO.getSender().getEmail(), UserDTO.class);
			messageDTO.setSender(sender);
			
		}
	
		return msgList;
	}

}
