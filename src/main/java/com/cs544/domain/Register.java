package com.cs544.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Register {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@Valid
	private Student student;
	@ManyToOne
	@Valid
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
