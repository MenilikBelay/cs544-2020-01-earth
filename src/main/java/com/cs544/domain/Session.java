package com.cs544.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private Location location;
	@ManyToOne
	private Timeslot timeslot;
	@Temporal(TemporalType.DATE)
	private Date date;
	@OneToMany
	@JsonIgnore
	private List<Record> records;
	
  
	public Session() {
		this.records = new ArrayList<Record>();
	}
	public Session(Location location, Timeslot timeslot, Date date) {
		this();
		this.location = location;
		this.timeslot = timeslot;
		this.date = date;
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
