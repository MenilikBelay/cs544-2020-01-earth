package com.cs544.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Student extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String studentID;
	private String barcode;

	@Override
	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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
