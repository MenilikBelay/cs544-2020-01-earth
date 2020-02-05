package com.cs544.domain;

import javax.persistence.*;

@Entity
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Student student;
	@ManyToOne
	private CourseOffering courseOffering;
	
	public Register() {}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public CourseOffering getOfferedCourses() {
		return courseOffering;
	}
	public void setOfferedCourses(CourseOffering courseOffering) {
		this.courseOffering = courseOffering;
	}
	
}
