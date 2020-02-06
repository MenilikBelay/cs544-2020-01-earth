package com.cs544.domain;

import javax.persistence.*;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Timeslot {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	private String description;
	@Temporal(TemporalType.TIME)
	private Date beginTime;
	@Temporal(TemporalType.TIME)
	private Date endTime;
	private String abbrevition;

	public Timeslot(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timeslot(String description, Date beginTime, Date endTime, String abbrevition) {
	this.description = description;
	this.beginTime = beginTime;
	this.endTime = endTime;
	this.abbrevition = abbrevition;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getAbbrevition() {
		return abbrevition;
	}
	public void setAbbrevition(String abbrevition) {
		this.abbrevition = abbrevition;
	}
	  
  
}
