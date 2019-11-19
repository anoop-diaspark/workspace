package com.diaspark.country.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.diaspark.country.entity.CountryEntity;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity, Long> {
	CountryEntity findCountryById(Long country_id);
	 @Query("SELECT t FROM CountryEntity t WHERE t.countryCode = 345 or t.countryCode = 123")
	List<CountryEntity> findDataBycountryName(String countryName);
	List<CountryEntity> findDataBycountryCode(int countryCode);
	List<CountryEntity> findDataBystateName(String stateName);
	
}
