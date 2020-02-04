package com.cs544.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Timeslot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id; 
  private String description;
  private Date beginTime;
  private Date endTime;
  private String abbrevition;


	public Timeslot() {
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
