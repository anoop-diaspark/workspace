package com.diaspark.country.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matchschedule")
public class ScheduleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "match_id", unique = true)
	private Long id;
	
	@Column(nullable = false)
	private String countryName;
	
	@Column(nullable = false)
	private String matchType;
	
	@Column(nullable = false, unique = true)
	private String date;
	
/*	this mapping makes the relation between SecheduleDAO and ResultDAO*/
	@OneToOne(cascade = CascadeType.ALL)
	private ResultEntity result;

	public ResultEntity getResult() {
		return result;
	}

	public void setResult(ResultEntity result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ScheduleDAO [id=" + id + ", countryName=" + countryName + ", matchType=" + matchType + ", date=" + date
				+ "]";
	}

	public ScheduleEntity() {

	}

	public ScheduleEntity(Long id, String countryName, String matchType, String date) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.matchType = matchType;
		this.date = date;
	}

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

	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
