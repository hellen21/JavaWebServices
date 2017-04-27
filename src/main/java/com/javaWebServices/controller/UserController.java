package com.javaWebServices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaWebServices.Dtos.UserDto;
import com.javaWebServices.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {


    private final UserService service;
 
    @Autowired
    UserController(UserService service) {
        this.service = service;
    }
 
    @RequestMapping(method = RequestMethod.POST)
    //@ResponseStatus(HttpStatus.CREATED)
    UserDto create(@RequestBody @Valid UserDto userEntry) {
        return service.create(userEntry);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    UserDto delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<UserDto> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    UserDto findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    UserDto update(@RequestBody @Valid UserDto todoEntry) {
        return service.update(todoEntry);
    }
}
