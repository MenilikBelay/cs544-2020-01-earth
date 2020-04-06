package com.cs544.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	@Column(unique = true)
	@NotEmpty(message = "Required to fill this field")
	@Size(min = 2 , max = 20)
	private String locationID;
	@Lob
	@NotNull(message = "this field Requires")
	private String description;
  
	public Location(){}
	
	public Location(String locationID , String description) {
		this.description = description;
		this.locationID = locationID;

	}
	
	public String getLocationID() {
		return locationID;
	}
	public void setLocationID(String locationID) {
		this.locationID = locationID;
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
