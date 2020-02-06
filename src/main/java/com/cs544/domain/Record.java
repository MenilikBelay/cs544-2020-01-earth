package com.cs544.domain;

import javax.persistence.*;

@Entity
@Table(name="attendance")
public class Record {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	private Student student;
	public Record() {}
	
	public Record(Student student) {
		this.student = student;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
