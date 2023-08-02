package com.springsecretmanager.springsecretmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import com.springsecretmanager.springsecretmanager.service.SecretManagerService;

@SpringBootApplication
public class SpringSecretManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecretManagerApplication.class, args);
	}
	
	
	 
}
