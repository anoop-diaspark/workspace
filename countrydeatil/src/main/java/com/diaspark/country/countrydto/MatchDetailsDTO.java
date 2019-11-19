package com.diaspark.country.countrydto;

import java.util.Set;

public class MatchDetailsDTO {

	private Set<String> countryName;
	private Set<String> matchType;
	public Set<String> getCountryName() {
		return countryName;
	}
	public void setCountryName(Set<String> countryName) {
		this.countryName = countryName;
	}
	public Set<String> getMatchType() {
		return matchType;
	}
	public void setMatchType(Set<String> matchType) {
		this.matchType = matchType;
	}
	
	
}
