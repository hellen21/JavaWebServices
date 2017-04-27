package com.javaWebServices.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.javaWebServices.entities.User;

public interface UserRepository extends Repository<User, String> {

	void delete(User deleted);
	
	List<User> findAll();
 
	User findOne(String id);
 
	User save(User saved);
}
