package com.diaspark.country.repository;



import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.diaspark.country.entity.ScheduleEntity;
@Repository
public interface ScheduelRepository extends JpaRepository<ScheduleEntity,Long>{
	  @Transactional
	
	    List<ScheduleEntity> removeScheduleDAOById(Long id);
	  ScheduleEntity findScheduleDAOById(Long id);
	  @Transactional
	    List<ScheduleEntity> removeScheduleDAOBycountryName(String countryName);
	  @Transactional  
	  List<ScheduleEntity> removeScheduleDAOBymatchType(String matchType);
	  @Transactional
	  List<ScheduleEntity> removeScheduleDAOBydate(String matchDate);
	  ScheduleEntity findTopByid(Long id);
	  
	  ScheduleEntity findTop1Bydate(String matchDate);
	  Page<ScheduleEntity> findScheduleEntityByCountryNameInOrMatchTypeIn(Set<String> countryName,Set<String>matchType, Pageable pageable);
	  Page<ScheduleEntity> findScheduleEntityByCountryNameInAndMatchTypeIn(Set<String> countryName,Set<String>matchType, Pageable pageable);
}
