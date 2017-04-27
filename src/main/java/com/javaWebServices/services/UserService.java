package com.javaWebServices.services;

import java.util.List;

import com.javaWebServices.Dtos.UserDto;

public interface UserService {
	UserDto create(UserDto user);
	 
	UserDto delete(String id);
 
    List<UserDto> findAll();
 
    UserDto findById(String id);
 
    UserDto update(UserDto user);
}
