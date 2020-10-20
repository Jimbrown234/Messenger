package com.brown.MessengerMessageMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.brown.MessageMS.controller.MessageController;
import com.brown.MessageMS.entity.Message;
import com.brown.MessageMS.service.MessageService;

@SpringBootApplication(scanBasePackageClasses = {MessageService.class,MessageController.class})
@EntityScan(basePackageClasses = Message.class)
@EnableJpaRepositories("com.brown.MessageMS.repository")
public class MessengerMessageMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessengerMessageMsApplication.class, args);
	}

}
