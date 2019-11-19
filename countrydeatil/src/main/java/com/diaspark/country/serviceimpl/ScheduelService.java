package com.diaspark.country.serviceimpl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

import com.diaspark.country.countrydto.MatchDetailsDTO;
import com.diaspark.country.countrydto.MatchScheduleDTO;
import com.diaspark.country.entity.ResultEntity;
import com.diaspark.country.entity.ScheduleEntity;
import com.diaspark.country.enums.MatchStatus;
import com.diaspark.country.enums.MatchType;
import com.diaspark.country.exception.InvalidDataException;
import com.diaspark.country.mapper.EntityToDTOMapper;

import com.diaspark.country.repository.ScheduelRepository;
import com.diaspark.country.service.MatchService;

@Service
public class ScheduelService implements MatchService {

	@Autowired
	private ScheduelRepository scheduelRepository;

	@Autowired
	private EntityToDTOMapper entityToDTOMapper;
	


	/* this is the function which save the match schedule data in table */
	@Override
	public MatchScheduleDTO matchlist(MatchScheduleDTO matchScheduleDTO) {
		MatchStatus.findCodeBymatchResult(matchScheduleDTO.getMatchStatus());
		MatchType.findMatchTypeByType(matchScheduleDTO.getMatchType());
		ScheduleEntity schedule = new ScheduleEntity();
		ScheduleEntity schedule1 = new ScheduleEntity();
		ResultEntity result = new ResultEntity();

		schedule.setCountryName(matchScheduleDTO.getCountryName());
		schedule.setDate(matchScheduleDTO.getMatchDate());

		result.setMatchStatus(matchScheduleDTO.getMatchStatus());
		schedule.setResult(result);
		schedule.setMatchType(MatchType.ODI.getMatchType());
		schedule1 = scheduelRepository.save(schedule);


		return entityToDTOMapper.buildMatchResponseDTO(schedule1);
	}

	/*
	 * this is the function which return all the data from schedule table and
	 * result table
	 */
	@Override
	public List<MatchScheduleDTO> retrieveallMatchlDetail(int pageNumber) {
		List<MatchScheduleDTO> allCountryData = new ArrayList<>();
		Pageable pageRequest = PageRequest.of(0, pageNumber, Sort.Direction.ASC, "countryName");
		Page<ScheduleEntity> matchList = scheduelRepository.findAll(pageRequest);

		for (ScheduleEntity matchOf : matchList) {
			MatchScheduleDTO countryResponseDTO = entityToDTOMapper.buildMatchResponseDTO(matchOf);
			allCountryData.add(countryResponseDTO);

		}

		return allCountryData;
	}

	@Override
	public List<MatchScheduleDTO> retrieveallMatchlDetails(int pageNumber, MatchDetailsDTO matchDetailsDTO) {
		// TODO Auto-generated method stub
		List<MatchScheduleDTO> allCountryData = new ArrayList<>();
		Pageable pageRequest = PageRequest.of(0, pageNumber);
		if(matchDetailsDTO.getCountryName().isEmpty() || matchDetailsDTO.getMatchType().isEmpty()){
			Page<ScheduleEntity> matchList = scheduelRepository.findScheduleEntityByCountryNameInOrMatchTypeIn(
					matchDetailsDTO.getCountryName(), matchDetailsDTO.getMatchType(), pageRequest);
			for (ScheduleEntity matchOf : matchList) {
				MatchScheduleDTO countryResponseDTO = entityToDTOMapper.buildMatchResponseDTO(matchOf);
				allCountryData.add(countryResponseDTO);

			}
			
		}
		else{
			Page<ScheduleEntity> matchList = scheduelRepository.findScheduleEntityByCountryNameInAndMatchTypeIn(
					matchDetailsDTO.getCountryName(), matchDetailsDTO.getMatchType(), pageRequest);
			for (ScheduleEntity matchOf : matchList) {
				MatchScheduleDTO countryResponseDTO = entityToDTOMapper.buildMatchResponseDTO(matchOf);
				allCountryData.add(countryResponseDTO);

			}
		}
		

	

		return allCountryData;

	}

	/* this is the function which delete one row data */
	@Override
	public List<MatchScheduleDTO> deleteOneRecord(Long id, int pageNumber) {
		List<MatchScheduleDTO> allCountryData = new ArrayList<>();
		scheduelRepository.removeScheduleDAOById(id);

		Pageable pageRequest = PageRequest.of(0, pageNumber);
		Page<ScheduleEntity> matchList = scheduelRepository.findAll(pageRequest);

		for (ScheduleEntity countryOf : matchList) {
			MatchScheduleDTO countryResponseDTO = entityToDTOMapper.buildMatchResponseDTO(countryOf);
			allCountryData.add(countryResponseDTO);
		}

		return allCountryData;
	}

	@Override
	public List<MatchScheduleDTO> deleteRecordBycountryNameOrmatchTypeOrmatchDate(String countryName, String matchType,
			String matchDate) {
		if (countryName != "") {
			List<MatchScheduleDTO> allCountryData = new ArrayList<>();
			List<ScheduleEntity> countryList = (List<ScheduleEntity>) scheduelRepository
					.removeScheduleDAOBycountryName(countryName);

			for (ScheduleEntity countryOf : countryList) {
				MatchScheduleDTO countryResponseDTO = entityToDTOMapper.buildMatchResponseDTO(countryOf);
				allCountryData.add(countryResponseDTO);
			}

			return allCountryData;
		}

		else if (matchType != "") {
			List<MatchScheduleDTO> allCountryData = new ArrayList<>();
			List<ScheduleEntity> countryList = (List<ScheduleEntity>) scheduelRepository
					.removeScheduleDAOBymatchType(matchType);

			for (ScheduleEntity countryOf : countryList) {
				MatchScheduleDTO countryResponseDTO = entityToDTOMapper.buildMatchResponseDTO(countryOf);
				allCountryData.add(countryResponseDTO);
			}

			return allCountryData;
		} else if (matchDate != "") {
			if (matchType.equals(MatchType.Test.getMatchType()) || matchType.equals(MatchType.T20.getMatchType())
					|| matchType.equals(MatchType.ODI.getMatchType())) {
				List<MatchScheduleDTO> allCountryData = new ArrayList<>();
				List<ScheduleEntity> countryList = (List<ScheduleEntity>) scheduelRepository
						.removeScheduleDAOBydate(matchDate);

				for (ScheduleEntity countryOf : countryList) {
					MatchScheduleDTO countryResponseDTO = entityToDTOMapper.buildMatchResponseDTO(countryOf);
					allCountryData.add(countryResponseDTO);
				}

				return allCountryData;
			} else {
				throw new InvalidDataException("Incorrect match type");
			}

		} else {
			throw new InvalidDataException("given data is Incorrect");
		}
	}

	/* this function update the one row recored by id */
	@Override
	public MatchScheduleDTO updateMatchSchedule(Long id, String countryName, String matchType, String matchDate,
			String matchStatus) {
		ScheduleEntity scheduleDAO = scheduelRepository.findScheduleDAOById(id);
		if (countryName == "") {

		} else {
			scheduleDAO.setCountryName(countryName);
		}
		if (matchType == "") {

		} else {
			MatchType.findMatchTypeByType(matchType);
			scheduleDAO.setMatchType(matchType);
			
		}
		if (matchDate == "") {

		} else {
			scheduleDAO.setDate(matchDate);

		}
		if (matchStatus == "") {

		} else {
			MatchStatus.findCodeBymatchResult(matchStatus);
			scheduleDAO.getResult().setMatchStatus(matchStatus);
		}
		ScheduleEntity savedDetails = scheduelRepository.save(scheduleDAO);
		return entityToDTOMapper.buildMatchResponseDTO(savedDetails);
	}

}
