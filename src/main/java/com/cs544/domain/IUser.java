package com.cs544.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "users")
public class IUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public String email;
	public String password;
	public String firstName;
	public String lastName;
	
	@ElementCollection(targetClass = Role.class)
	@JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	public List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public IUser() {}
	public IUser (String email ,String password , String firstName,String lastName,List<Role> roles ) {
		this.email = email;
		this.firstName=firstName;
		this.password=password;
		this.lastName =lastName;
		this.roles = new ArrayList<>();
		this.roles.addAll(roles);
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirsName() {
		return firstName;
	}
	public void setFirsName(String firsName) {
		this.firstName = firsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
