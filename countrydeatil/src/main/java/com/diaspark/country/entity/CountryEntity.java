package com.diaspark.country.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

/* this table is separate and store only country details */

@Entity
@Table(name = "countrydetail")
public class CountryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id", unique = true)
	private Long id;
	
	@Column
	private String countryName;
	@Column
	private int countryCode;
	@Column
	private String stateName;

	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(int countryCode) {
		this.countryCode = countryCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	

}
