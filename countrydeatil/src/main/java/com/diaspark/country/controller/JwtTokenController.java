package com.diaspark.country.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.diaspark.country.config.JwtTokenUtil;
import com.diaspark.country.countrydto.JwtRequest;
import com.diaspark.country.entity.JwtResponse;

import com.diaspark.country.service.JwtTokenInterface;

@RestController
public class JwtTokenController {

	

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenInterface jwtTokenInterface;

	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		
		  authenticate(authenticationRequest.getUserName(),
		  authenticationRequest.getPassword());
		 

		final UserDetails userDetails = jwtTokenInterface.loadUserByUsername(authenticationRequest.getUserName());
	

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));

		
	}
	
	  private void authenticate(String username, String password) throws
	 Exception { try { authenticationManager.authenticate(new
	  UsernamePasswordAuthenticationToken(username, password)); } catch
	  (DisabledException e) { throw new Exception("USER_DISABLED", e); } catch
	  (BadCredentialsException e) { throw new Exception("INVALID_CREDENTIALS",
	  e); } }
	 
}
