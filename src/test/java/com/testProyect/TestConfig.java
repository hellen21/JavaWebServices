package com.testProyect;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.javaWebServices.controller.UserController;
import com.javaWebServices.repository.UserRepository;

@Configuration
public class TestConfig {
	 @Bean
	    @Primary
	    public UserController nameService() {
	        return Mockito.mock(UserController.class);
	    }
	 
	 @Bean
	    @Primary
	    public UserRepository nameServiceR() {
	        return Mockito.mock(UserRepository.class);
	    }
}
