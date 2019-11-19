package com.diaspark.country.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.diaspark.country.countrydto.RegisterSenderDTO;
import com.diaspark.country.countrydto.RegisterUserDTO;
import com.diaspark.country.entity.UserEntity;
import com.diaspark.country.mapper.EntityToDTOMapper;
import com.diaspark.country.service.UserService;
import com.diaspark.country.repository.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	  @Autowired
	  private UsersRepository usersRepository;
	
	  
	  @Autowired
	  private EntityToDTOMapper entityToDTOMapper;
	  
	  @Autowired
		private PasswordEncoder bcryptEncoder;
	@Override
	public RegisterSenderDTO registerUser(RegisterUserDTO registerUserDTO) {
		// TODO Auto-generated method stub
		UserEntity userDAO = new UserEntity();
		userDAO.setFirstName(registerUserDTO.getFirstName());
		userDAO.setLastName(registerUserDTO.getLastName());
		userDAO.setUserName(registerUserDTO.getUserName());
		userDAO.setPassword(bcryptEncoder.encode(registerUserDTO.getPassword()));
		userDAO.setEmailId(registerUserDTO.getEmailId());
		userDAO.setMobileNumber(registerUserDTO.getMobileNumber());
		UserEntity savedUser =  usersRepository.save(userDAO);
		RegisterUserDTO RegisterUserDTO = entityToDTOMapper.buildRegisterUserDTO(savedUser);
		RegisterSenderDTO registerSenderDTO = new RegisterSenderDTO();
		registerSenderDTO.setFirstName(savedUser.getFirstName());
		registerSenderDTO.setMessage("User registered Successfully");
		return registerSenderDTO;
	}

}
