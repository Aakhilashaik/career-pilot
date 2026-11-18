package com.careerpilot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.careerpilot.model.LoginRequest;
import com.careerpilot.model.User;
import com.careerpilot.service.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

	@Autowired
	private AuthService authService;

	// Register API
	@PostMapping("/register")
	public String register(@RequestBody User user) {

		return authService.register(user);
	}

	// Login API
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {

		return authService.login(
				loginRequest.getEmail(),
				loginRequest.getPassword());
	}
}