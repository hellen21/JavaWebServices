package com.javaWebServices.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaWebServices.entities.User;
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
    User create(@RequestBody @Valid User userEntry) {
        return service.create(userEntry);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    User delete(@PathVariable("id") String id) {
        return service.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<User> findAll() {
        return service.findAll();
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    User findById(@PathVariable("id") String id) {
        return service.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    User update(@RequestBody @Valid User todoEntry) {
        return service.update(todoEntry);
    }
}
