package com.javaWebServices.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaWebServices.entities.User;
import com.javaWebServices.repository.UserRepository;
@Component
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Api(value = "User Controller", produces = "application/json")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GET
	@ApiOperation(value = "Gets a User. Version 1 - (version in URL)", response = UserController.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Get found"),
	    @ApiResponse(code = 404, message = "Get not found")
	})
	public List<User> getUsers(@ApiParam @PathParam("id") Long id) {
		List<User> listUser = new ArrayList<User>();
		User user = new User();
		if (id == null) {
			return userRepository.findAll();
		}
		user = userRepository.findOne(id);
		if (user != null) {
			listUser.add(user);
		}

		return listUser;
	}

	@POST
	@Produces("application/json")
	@ApiOperation(value = "Post User Version 1 - (version in URL)", response = UserController.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Post found"),
	    @ApiResponse(code = 404, message = "Post not found")
	})
	public User create(User userEntry){
		if(!isValidUser(userEntry)){
			return null;
		}
		return userRepository.save(userEntry);
	}

	@PUT
	@Produces("application/json")
	@ApiOperation(value = "PUT User Version 1 - (version in URL)", response = UserController.class)
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "PUT found"),
	    @ApiResponse(code = 404, message = "PUT not found")	
		})
	public User update(User userEntry) {
		if (userEntry.getId() != null) {
			return userRepository.save(userEntry);
		}
		return userEntry;
	}

	@DELETE
	@ApiOperation(value = "DELETE User Version 1 - (version in URL)")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "DELETE found"),
	    @ApiResponse(code = 404, message = "DELETE not found")	
		})
	public void delete(@ApiParam @QueryParam("id") Long id) {
		if (id != null) {
			userRepository.delete(id);
		}
	}

	private boolean isValidUser(User user) {
		if (user.getName() == null) {
			return false;
		}
		if (user.getSurname() == null) {
			return false;
		}
		if (user.getUserName() == null) {
			return false;
		}
		if (user.getPassword() == null) {
			return false;
		}
		if (user.getEmailAddress() == null) {
			return false;
		}
		if (user.getPhoneNumber() == null) {
			return false;
		}
		return true;
	}
}
