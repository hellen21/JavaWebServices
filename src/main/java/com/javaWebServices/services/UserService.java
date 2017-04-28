package com.javaWebServices.services;

import java.util.List;

import com.javaWebServices.entities.User;

public interface UserService {
	User create(User user);
	 
	User delete(String id);
 
    List<User> findAll();
 
    User findById(String id);
 
    User update(User user);
}
