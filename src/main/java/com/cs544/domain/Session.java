package com.cs544.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@NotNull(message = "Required to fill this field")
	@Size(min = 0 , max = 20 ,message = "must be in range 2-20")
	String sessionID;
	@ManyToOne
	@Valid
	private Location location;
	@ManyToOne
	@Valid
	private Timeslot timeslot;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToMany
	@JsonIgnore
	private List<@Valid Record> records;
	
  
	public Session() {
		this.records = new ArrayList<Record>();
	}
	public Session(Location location, Timeslot timeslot, Date date) {
		this();
		this.location = location;
		this.timeslot = timeslot;
		this.date = date;
		this.records = new ArrayList<Record>();
	}
	
	public void setRecord(List<Record> records) {
		this.records.addAll(records);
	}
	
	public List<Record> getRecords() {
		return records;
	}
	public void setRecords(List<Record> records) {
		this.records = records;
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
	
	public void addRecord (Record record) {
		if (record != null) {
			this.records.add(record);
		}
	}
}
