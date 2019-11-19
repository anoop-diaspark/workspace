package com.diaspark.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diaspark.country.countrydto.RegisterSenderDTO;
import com.diaspark.country.countrydto.RegisterUserDTO;
import com.diaspark.country.service.UserService;


@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public RegisterSenderDTO matchlist(@RequestBody RegisterUserDTO registerUserDTO) {
		return userService.registerUser(registerUserDTO);
	}
}
