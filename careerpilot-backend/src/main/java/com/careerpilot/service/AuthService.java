package com.careerpilot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.careerpilot.model.User;
import com.careerpilot.repository.UserRepository;

@Service
public class AuthService {

	@Autowired
	private UserRepository userRepository;

	// Register User
	public String register(User user) {

		User existingUser = userRepository.findByEmail(user.getEmail());

		if (existingUser != null) {

			System.out.println("User already exists");

			return "Email already registered";
		}

		System.out.println("New User");

		user.setRole("CANDIDATE");

		int result = userRepository.saveUser(user);

		if (result > 0) {
			return "User Registered Successfully";
		}

		return "Registration Failed";
	}

	// Login User
	public String login(String email, String password) {

		User user = userRepository.findByEmail(email);

		if (user == null) {
			return "User Not Found";
		}

		if (!user.getPassword().equals(password)) {
			return "Invalid Password";
		}

		return "Login Successful";
	}
}