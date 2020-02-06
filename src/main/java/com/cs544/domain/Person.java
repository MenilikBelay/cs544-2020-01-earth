package com.cs544.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Required to fill this field")
	@Email(message = "must be in email format")
	private String email;
	@NotNull
	@Size(min=2,max = 12 , message ="length must be 2 - 12 ")
	private String password;
	@NotNull(message = "Required to fill this field")
	private String firstName;
	@NotNull(message = "Required to fill this field")
	private String lastName;
	@OneToMany
	@JoinColumn(name = "user_id")
	private List<PersonRole> personRoles; 

	public Person () {}
	
	public Person (String email ,String password , String firstName,String lastName, List<PersonRole> roles) {
		if (roles == null || roles.isEmpty()) {
			//throw exception as at least one role is required
			throw new IllegalArgumentException("Role can not be empty for a user");
		} else if (roles.size() > 3) {
			throw new IllegalArgumentException("User can not have more than three roles");
		}
		this.email = email;
		this.firstName=firstName;
		this.password=password;
		this.lastName =lastName;
		this.personRoles = roles;
	}
	
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public List<PersonRole> getPersonRoles() {
		return personRoles;
	}

	public void setPersonRoles(List<PersonRole> roles) {
		this.personRoles = roles;
	}

	public String getEmail() {
		return email;
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
	
	/**
	 * Return list of roles a person has.
	 * @return
	 */
	public List<Role> getRoles() {
		return personRoles.parallelStream()
				.map(pr -> pr.getRole())
				.collect(Collectors.toList());
	}

}