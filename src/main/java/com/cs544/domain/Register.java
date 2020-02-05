package com.cs544.domain;

import javax.persistence.*;

@Entity
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	public Student student ;
	@ManyToOne
	public CourseOffering offeringCourses ;
	
	public Register() {}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public CourseOffering getOfferingCourses() {
		return offeringCourses;
	}
	public void setOfferingCourses(CourseOffering offeringCourses) {
		this.offeringCourses = offeringCourses;
	}
	
}
