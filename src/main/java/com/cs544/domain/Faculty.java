package com.cs544.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Faculty extends PersonRole {
	@NotNull(message = "Required to fill this field")
	@Size(min = 1 , max = 20)
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
