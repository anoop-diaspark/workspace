package com.diaspark.country.countrydto;

/*for takinall the rest data of match related info*/

public class MatchScheduleDTO {
	private Long id;
	private String countryName;
	private String matchType;
	private String matchDate;
private String matchStatus;
	public String getMatchStatus() {
		return matchStatus;
	}
	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMatchDate() {
		return matchDate;
	}
	public void setMatchDate(String matchDate) {
		this.matchDate = matchDate;
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

	
	
	
}
