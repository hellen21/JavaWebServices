package com.javaWebServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;


@SpringBootApplication
(scanBasePackages = {
        "com.javaWebServices.config", "com.javaWebServices.controller"
    })
public class JavaWebServicesApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(JavaWebServicesApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JavaWebServicesApplication.class);
	}
}
