package com.signup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.signup.model.User;
import com.signup.service.Service_interface;
import com.signup.service.UserService;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController 
{
	@Autowired
	private Service_interface service;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) 
	{
		return service.insert(user);//insert data into the database
	}
	@GetMapping("/checklogin/{email}/{password}")
	public String findByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
	    return service.findByEmailAndPassword(email, password);
	}
}
