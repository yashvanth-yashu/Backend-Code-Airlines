package com.signup.service;
import com.signup.model.User;
public interface Service_interface 
{
	public String findByEmailAndPassword(String email, String password);
	public User insert(User user);
}
