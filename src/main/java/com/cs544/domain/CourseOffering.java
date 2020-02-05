package com.cs544.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CourseOffering {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	private String courseOfferingId;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@ManyToOne
	private Course course ;
	@OneToMany
	private List<Session> session;
	
	public CourseOffering() {}
	
	public CourseOffering(Date startDate, Date endDate, Course course,
			List<Session> session) {
		this.endDate = endDate;
		this.startDate = startDate;
		this.course = course;
		this.session = new ArrayList<>();
		this.session.addAll(session);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void addSession(Session session )
	{
		this.session.add(session);
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

	public String getCourseOfferingId() {
		return courseOfferingId;
	}

	public void setCourseOfferingId(String courseOfferingId) {
		this.courseOfferingId = courseOfferingId;
	}	

}
