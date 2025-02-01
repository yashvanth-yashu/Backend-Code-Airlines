package com.signup.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signup.model.User;
import com.signup.repository.UserRepository;

@Service
public class UserService implements Service_interface
{
	@Autowired
	private UserRepository userRepository;
	
	//login values
	@Override
	public String findByEmailAndPassword(String email, String password) {
	    List<User> u = userRepository.findByEmailAndPassword(email, password);
	    if (!u.isEmpty()) {
	        return "1";  // Login success
	    } else {
	        return "2";  // Login failed
	    }
	}

	@Override
	public User insert(User user)
	{
		return userRepository.save(user);
	}
}
