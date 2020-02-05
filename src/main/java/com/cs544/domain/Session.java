package com.cs544.domain;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	String sessionID;
	@ManyToOne(cascade = CascadeType.ALL)
	private Location location;
	@ManyToOne(cascade = CascadeType.ALL)
	private Timeslot timeslot;
	@Temporal(TemporalType.DATE)
	private Date date ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Record> records;
	  

	public Session() {}
	public Session(Location location, Timeslot timeslot, Date date) {
		this.location = location;
		this.timeslot = timeslot;
		this.date = date;
		this.records = new ArrayList<Record>();
	}

	public void addRecord(Record record)
	{
		this.records.add(record);
	}
	
	public List<Record> getRecords() {
		return this.records;
	}
	
	public void setRecord(List<Record> records) {
		this.records.addAll(records);
	}
	
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	
	public String getSessionId() {
		return sessionID;
	}
	public void setSessionId(String sessionId) {
		this.sessionID = sessionId;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Timeslot getTimeslot() {
		return timeslot;
	}
	public void setTimeslot(Timeslot timeslot) {
		this.timeslot = timeslot;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
