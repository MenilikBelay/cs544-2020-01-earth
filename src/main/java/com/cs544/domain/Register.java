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
	public OfferingCourses offeringCourses ;
	
	public Register() {}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public OfferingCourses getOfferingCourses() {
		return offeringCourses;
	}
	public void setOfferingCourses(OfferingCourses offeringCourses) {
		this.offeringCourses = offeringCourses;
	}
	
}
