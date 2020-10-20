package com.brown.MessengerUserMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.brown.UserMs.entity.User;

import com.brown.UserMs.controller.UserController;
import com.brown.UserMs.service.UserService;

@SpringBootApplication(scanBasePackageClasses = {UserService.class,UserController.class})
@EntityScan(basePackageClasses = User.class)
@EnableJpaRepositories("com.brown.UserMS.repository")
public class MessengerUserMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessengerUserMsApplication.class, args);
	}

}
