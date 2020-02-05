package com.cs544.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrator")
public class Admin extends PersonRole {
	
	public Admin() {
		super(Role.ADMIN);
	}

}
