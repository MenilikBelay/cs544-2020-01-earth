package com.cs544.domain;

import javax.persistence.*;
import java.util.Date;

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
	private Date date ;

	/*public Record getRecord() {
		return record;
	}

	public void setRecord(Record record) {
		this.record = record;
	}*/

/*	@OneToOne(cascade = CascadeType.REMOVE)
	@Nullable
	private Record record;*/

	public Session() {}
	public Session(Location location, Timeslot timeslot, Date date) {
		this.location = location;
		this.timeslot = timeslot;
		this.date = date;
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
}
