package com.diaspark.country.service;

import com.diaspark.country.countrydto.RegisterSenderDTO;
import com.diaspark.country.countrydto.RegisterUserDTO;

public interface UserService {
	RegisterSenderDTO registerUser(RegisterUserDTO registerUserDTO);
}
