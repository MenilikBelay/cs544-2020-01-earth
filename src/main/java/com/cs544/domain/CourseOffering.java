package com.cs544.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class CourseOffering {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	@NotNull(message = "Required to fill this field")
	private String courseOfferingID;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@ManyToOne
	@JsonIgnore
	@Valid
	private Course course ;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "offering_id")
	private List<@Valid   Session> session;
	
	public CourseOffering() {}
		
	
	public CourseOffering(String courseOfferingID, Date endDate, Date startDate, Course course,
						  List<Session> session) {
		this.courseOfferingID = courseOfferingID;
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

	public String getCourseOfferingID() {
		return courseOfferingID;
	}

	public void setCourseOfferingID(String courseOfferingID) {
		this.courseOfferingID = courseOfferingID;
	}	

}
