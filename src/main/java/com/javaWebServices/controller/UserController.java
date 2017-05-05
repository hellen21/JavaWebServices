package com.javaWebServices.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import com.javaWebServices.entities.User;
import com.javaWebServices.repository.UserRepository;

@Path("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GET
	@Produces("application/json")
	public List<User> getUsers(@QueryParam("id") Long id) {
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
	public User create(User userEntry){
		if(!isValidUser(userEntry)){
			return null;
		}
		return userRepository.save(userEntry);
	}

	@PUT
	@Produces("application/json")
	public User update(User userEntry) {
		if (userEntry.getId() != null) {
			return userRepository.save(userEntry);
		}
		return userEntry;
	}

	@DELETE
	public void delete(@QueryParam("id") Long id) {
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
