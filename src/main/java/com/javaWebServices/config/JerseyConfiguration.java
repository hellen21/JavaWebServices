/*
 * (C) 2016 World Animal Protection.  All Rights Reserved.  Confidential Information of World Animal Protection.
 */
package com.javaWebServices.config;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.javaWebServices.controller.UserController;

@Component
public class JerseyConfiguration extends ResourceConfig {

	@Value("${spring.jersey.application-path:/}")
	private String apiPath;
	 
	public JerseyConfiguration() {
		register(UserController.class);
		register(ApiListingResource.class);
		register(SwaggerSerializers.class);
		register(WadlResource.class);
		
		BeanConfig config = new BeanConfig();
		config.setConfigId("springboot-jersey-swagger-docker-example");
		config.setTitle("Test Swagger");
		config.setVersion("v1");
		config.setContact("Hellen Campos");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath(this.apiPath);
		config.setResourcePackage("com.javaWebServices.controller");
		config.setPrettyPrint(true);
		config.setScan(true);
	}
	

}
