package com.diaspark.country.service;

import org.springframework.security.core.userdetails.UserDetails;



public interface JwtTokenInterface {
	 UserDetails loadUserByUsername(String matchDate);
	
}
