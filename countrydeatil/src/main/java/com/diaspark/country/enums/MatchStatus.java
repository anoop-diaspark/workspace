package com.diaspark.country.enums;

import com.diaspark.country.exception.InvalidDataException;

public enum MatchStatus {
	WON("win"), LOSE("lose"), DRAW("draw"), UPCOMING("upcoming"), ONGOING("ongoing");

	private String matchStatus;

	private MatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}

	public String getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}
	/*
	 * this function validate the match status coming from rest api
	 */

	public static MatchStatus findCodeBymatchResult(String matchStatus) {
		for (MatchStatus roleType : values()) {
			if (matchStatus.equals(roleType.matchStatus)) {
				return roleType;
			}
		}
		throw new InvalidDataException("Incorrect role type");
	}
}
