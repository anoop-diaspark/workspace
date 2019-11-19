package com.diaspark.country.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.diaspark.country.countrydto.SendMailDTO;
import com.diaspark.country.entity.UserEntity;
import com.diaspark.country.exception.InvalidDataException;

import com.diaspark.country.repository.UsersRepository;
import com.diaspark.country.service.JwtTokenInterface;
@Service
public class JwtTokenService implements JwtTokenInterface,UserDetailsService{

	
	
	 @Autowired
	  private UsersRepository usersRepository;
	
	 /*  @Autowired
	    private mailService notificationService;*/
/*	this is the function which return the password and  username for authenticate*/
	
	@Override
	public UserDetails loadUserByUsername(String userName) {
	/*	ScheduleDAO schedule = scheduelRepository.findTop1Bydate(matchDate);*/
	
		UserEntity userDAO = usersRepository.findUserDAOByUserName(userName);
		if(userDAO == null){
			throw new InvalidDataException(" detail is invaild");
		}
	/*	sendMail(userDAO) ;*/
		return new org.springframework.security.core.userdetails.User(userDAO.getUserName(),userDAO.getPassword(),new ArrayList<>());
	}
	
	 /*  private void sendMail(UserDAO user) {
	   
	            SendMailDTO sendMailDTO = new SendMailDTO();
	            sendMailDTO.setToAddress(user.getEmailId());
	            sendMailDTO.setSubject("You are successfully logged in");
	            sendMailDTO.setQueries("Dear Customer, you have been successfully validated." + " " +  " " + "You can use our services.");
	            notificationService.sendEmail(sendMailDTO);
	        
	    }*/
}
