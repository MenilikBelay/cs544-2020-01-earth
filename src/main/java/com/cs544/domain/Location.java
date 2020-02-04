package com.cs544.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	@Lob
	private String description;
	
	public Location(){}
	public Location(long id, String description) {
		this.id = id;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
