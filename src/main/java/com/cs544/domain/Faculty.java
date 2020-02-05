package com.cs544.domain;

import javax.persistence.Entity;

@Entity
public class Faculty extends PersonRole {

	private String facultyId;
	
	public Faculty() {
		super(Role.FACULTY);
	}
	
	public Faculty(String facultyId) {
		this();
		this.facultyId = facultyId;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}	
}
