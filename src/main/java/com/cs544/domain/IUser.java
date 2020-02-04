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
	public String firsName;
	public String lastName;
	@ElementCollection
	@CollectionTable(name = "authorities")
	public List<String> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public IUser() {}
	public IUser (String email ,String password , String firstName,String lastName,List<String> roles ) {
		this.email = email;
		this.firsName=firstName;
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
		return firsName;
	}
	public void setFirsName(String firsName) {
		this.firsName = firsName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}








































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































