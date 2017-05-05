/*
 * (C) 2016 World Animal Protection.  All Rights Reserved.  Confidential Information of World Animal Protection.
 */
package com.javaWebServices.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import com.javaWebServices.controller.UserController;

@Configuration
@Component
public class JerseyConfiguration extends ResourceConfig {

	public JerseyConfiguration() {
		
		register(UserController.class);

	}
	

}
