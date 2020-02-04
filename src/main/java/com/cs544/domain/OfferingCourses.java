package com.cs544.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
public class OfferingCourses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String OfferingCourseID; 
	private LocalDate endDate;
	private LocalDate startDate;
	@ManyToOne
	private Course course ;
	@OneToMany
	@JoinColumn(name = "course_offering_id")
	private List<Session> session;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
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
