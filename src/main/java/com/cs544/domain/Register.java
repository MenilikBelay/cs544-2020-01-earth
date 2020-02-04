package com.cs544.domain;

public class Register {

	public Student student ; 
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
