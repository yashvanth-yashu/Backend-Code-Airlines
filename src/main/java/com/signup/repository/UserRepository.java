package com.signup.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.signup.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByEmailAndPassword(String email, String password);

}
