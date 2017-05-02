package com.javaWebServices.controller;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import com.javaWebServices.entities.User;
import com.javaWebServices.repository.UserRepository;

@Path("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GET
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@POST
    @Produces("application/json")
	public User create(User userEntry) {
		userEntry.getId();
        return userRepository.save(userEntry);
    }
 
//    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
//    void delete(@PathVariable("id") String id) {
//        userRepository.delete(id);
//    }
// 

// 
//    @RequestMapping(value = "{id}", method = RequestMethod.GET)
//    User findById(@PathVariable("id") String id) {
//        return userRepository.findById(id);
//    }
// 
//    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
//    User update(@RequestBody @Valid User todoEntry) {
//        return userRepository.update(todoEntry);
//    }
}
