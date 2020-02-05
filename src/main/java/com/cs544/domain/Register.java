package com.cs544.domain;

import javax.persistence.*;

@Entity
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL)
	public Student student ;
	@ManyToOne(cascade = CascadeType.ALL)
	public OfferedCourse offeringCourses ;
	
	public Register() {}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public OfferedCourse getOfferingCourses() {
		return offeringCourses;
	}
	public void setOfferingCourses(OfferedCourse offeringCourses) {
		this.offeringCourses = offeringCourses;
	}
	
}
