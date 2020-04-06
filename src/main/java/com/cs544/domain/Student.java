package com.cs544.domain;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student extends PersonRole {

	@NotNull(message = "Required to fill this field")
	@Size(min = 1 , max = 20)
	private String studentID;
	@NotNull(message = "Required to fill this field")
	@Size(min = 1 , max = 20)
	private String barcode;

	public Student() {
		super(Role.STUDENT);
	}
	
	public Student(String studentID, String barcode) {
		this();
		this.studentID = studentID;
		this.barcode = barcode;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}


	
}
