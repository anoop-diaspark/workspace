package com.diaspark.country.enums;

import com.diaspark.country.exception.InvalidDataException;

public enum MatchType {
	ODI("odi"), Test("test"), T20("t20");

	private String matchType;

	private MatchType(String matchType) {
		this.matchType = matchType;
	}

	public String getMatchType() {
		return matchType;
	}

	public void setMatchType(String matchType) {
		this.matchType = matchType;
	}

	public static MatchType findMatchTypeByType(String matchType) {
		for (MatchType roleType : values()) {
			if (matchType.equals(roleType.matchType)) {
				return roleType;
			}
		}
		throw new InvalidDataException("Incorrect matchType type");
	}

}
