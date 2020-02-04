package com.cs544.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OfferingCourses {

	private String OfferingCourseID; 
	private LocalDate endDate; 
	private LocalDate startDate; 
	
	private Course course ;
	private List<Session> session;
	
	public OfferingCourses() {}
		
	
	public OfferingCourses(String offeringCourseID, LocalDate endDate, LocalDate startDate, Course course,
			List<Session> session) {
		OfferingCourseID = offeringCourseID;
		this.endDate = endDate;
		this.startDate = startDate;
		this.course = course;
		this.session = new ArrayList<>();
		this.session.addAll(session);
	}

	public void addSession(Session session )
	{
		this.session.add(session);
	}

	public String getOfferingCourseID() {
		return OfferingCourseID;
	}
	public void setOfferingCourseID(String offeringCourseID) {
		OfferingCourseID = offeringCourseID;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Session> getSession() {
		return session;
	}
	public void setSession(List<Session> session) {
		this.session = session;
	}
	

}
