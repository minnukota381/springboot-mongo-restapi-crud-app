package com.neptune.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.neptune.model.User;
import com.neptune.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping
	public List<User> getAllUsers(){
    	return service.findAllUsers();
    }
	
	@GetMapping("/{id}")
	public User getUserByID(@PathVariable String id) {
    	return service.getUserByID(id);
    }
	
	@PutMapping
	public User updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable String id) {
		return service.deleteUser(id);
	}
}
