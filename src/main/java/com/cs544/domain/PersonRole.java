package com.cs544.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity

@Table(name = "user_role")
public  class PersonRole {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public PersonRole () {}
	
	public PersonRole (Role role) {
		if (role == null) {
			throw new IllegalArgumentException("Role can not be empty for user");
		}
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
