package com.cs544.domain;

import javax.persistence.Entity;

@Entity
public class Student extends PersonRole {

	private String studentID;
	private String barcode;

	private Student() {
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
