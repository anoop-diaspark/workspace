package com.diaspark.country.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.diaspark.country.countrydto.CountryResponseDTO;
import com.diaspark.country.entity.CountryEntity;
import com.diaspark.country.mapper.EntityToDTOMapper;
import com.diaspark.country.repository.CountryRepository;

@Service
public class ServiceImpl {
	@Autowired
	private CountryRepository countryRepository;
	

	
	@Autowired
	private EntityToDTOMapper entityToDTOMapper;
	
	public void countryData(CountryResponseDTO countryResponseDTO){
		System.out.println(countryResponseDTO.getCountryName());
		CountryEntity newCountrydetail = new CountryEntity();
		newCountrydetail.setCountryName(countryResponseDTO.getCountryName());
		
		newCountrydetail.setCountryCode(countryResponseDTO.getCountryCode());
		newCountrydetail.setStateName(countryResponseDTO.getStateName());
		
		countryRepository.save(newCountrydetail);
		
	
	}
	
	
	/*list of all Detail By country Name*/
	public List<CountryResponseDTO> retrieveDetailByCountryName(String countryName){
		  List<CountryResponseDTO> countryNames = new ArrayList<>();
	    List<CountryEntity> countryList = countryRepository.findDataBycountryName(countryName);
	 
		for(CountryEntity countryOf : countryList){
			CountryResponseDTO countryResponseDTO = entityToDTOMapper.buildCountryResponseDTO(countryOf);
			countryNames.add(countryResponseDTO);
		}
		
		
		return countryNames;
	}
	

	
	/*	list of all Detail By stateName*/
	public List<CountryResponseDTO> retrieveDetailBystateName(String stateName){
		  List<CountryResponseDTO> stateNames = new ArrayList<>();
	    List<CountryEntity> countryList = countryRepository.findDataBystateName(stateName);
		
		for(CountryEntity countryOf : countryList){
			CountryResponseDTO countryResponseDTO = entityToDTOMapper.buildCountryResponseDTO(countryOf);
			stateNames.add(countryResponseDTO);
		}
		
		return stateNames;
	}
	
	/*	list of all Detail */
	public List<CountryResponseDTO> retrieveallDetail(){
		 List<CountryResponseDTO> allCountryData = new ArrayList<>();
		    List<CountryEntity> countryList = (List<CountryEntity>) countryRepository.findAll();
			
			for(CountryEntity countryOf : countryList){
				CountryResponseDTO countryResponseDTO = entityToDTOMapper.buildCountryResponseDTO(countryOf);
				allCountryData.add(countryResponseDTO);
			}
			
			return allCountryData;
	}
	
}


