package com.cs544.domain;

public class Record {
	private long id;
	private Student student;
	private Session session;

	public Record() {}
	
	public Record(long id, Student student, Session session) {
		this.id = id;
		this.student = student;
		this.session = session;
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
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
}
