package com.diaspark.country.mapper;

import org.springframework.stereotype.Component;

import com.diaspark.country.countrydto.CountryResponseDTO;
import com.diaspark.country.countrydto.MatchScheduleDTO;
import com.diaspark.country.countrydto.RegisterUserDTO;
import com.diaspark.country.entity.CountryEntity;

import com.diaspark.country.entity.ScheduleEntity;
import com.diaspark.country.entity.UserEntity;
@Component
public class EntityToDTOMapper {
	
/*	this is the function which convert country entity data to dto */
	 public CountryResponseDTO buildCountryResponseDTO(CountryEntity countryOf) {
		 CountryResponseDTO contryResponseDTO = new CountryResponseDTO();
		 contryResponseDTO.setCountryName(countryOf.getCountryName());
		 contryResponseDTO.setCountryCode(countryOf.getCountryCode());
		 contryResponseDTO.setStateName(countryOf.getStateName());
	      
	        return contryResponseDTO;
	    }

	 
	 /*	this is the function which convert match  entity data to dto */
	 public MatchScheduleDTO buildMatchResponseDTO(ScheduleEntity countryOf) {
		 MatchScheduleDTO matchResponseDTO = new MatchScheduleDTO();
		 matchResponseDTO.setId(countryOf.getId());
		 matchResponseDTO.setCountryName(countryOf.getCountryName());
		matchResponseDTO.setMatchDate(countryOf.getDate());
		matchResponseDTO.setMatchType(countryOf.getMatchType());
		matchResponseDTO.setMatchStatus(countryOf.getResult().getMatchStatus());
	        return matchResponseDTO;
	    }
	 
	 public RegisterUserDTO buildRegisterUserDTO(UserEntity userDAO){
		 RegisterUserDTO registerUserDTO = new RegisterUserDTO();
		 registerUserDTO.setFirstName(userDAO.getFirstName());
		 registerUserDTO.setLastName(userDAO.getLastName());
		 registerUserDTO.setUserName(userDAO.getUserName());
		
		 return registerUserDTO;
		 
	 }
	 
}
