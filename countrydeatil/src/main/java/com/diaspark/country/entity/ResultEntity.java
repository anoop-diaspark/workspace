package com.diaspark.country.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "result")
public class ResultEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "result_id", unique = true)
	private Long id;
	
	/* referencing the parent ScheduleDAO table with one to one mapping */
	@OneToOne(cascade=CascadeType.ALL)
	 @JoinColumn(name = "result_id", referencedColumnName = "match_id")
	private ScheduleEntity scheduleDAO;
	
	
	@Column(nullable = false)
	private String matchStatus;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ScheduleEntity getScheduleDAO() {
		return scheduleDAO;
	}
	public void setScheduleDAO(ScheduleEntity scheduleDAO) {
		this.scheduleDAO = scheduleDAO;
	}

	public String getMatchStatus() {
		return matchStatus;
	}
	public void setMatchStatus(String matchStatus) {
		this.matchStatus = matchStatus;
	}
	
	
}
