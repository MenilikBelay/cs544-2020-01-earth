package com.cs544.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class OfferedCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String OfferingCourseID;
	@Temporal(TemporalType.DATE)
	private Date endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.DATE)
	private Date startDate;
	@ManyToOne
	private Course course ;
	@OneToMany
	@JoinColumn(name = "offering_id")
	private List<Session> session;
	
	public OfferedCourse() {}
		
	
	public OfferedCourse(String offeringCourseID, Date endDate, Date startDate, Course course,
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
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
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
