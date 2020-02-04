package com.cs544.domain;

import java.util.List;

public class Student extends IUser {

	private String studentID;
	private String barcode;
		
	public Student() {}
	
	public Student(String email ,String password , String firstName,String lastName , String studentID, String barcode , List<String>roles ) {
		super(email, password, firstName, lastName , roles);
	
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
