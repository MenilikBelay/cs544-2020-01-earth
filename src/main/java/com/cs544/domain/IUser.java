package com.cs544.domain;

import java.util.ArrayList;
import java.util.List;

public class IUser {
	public String email;
	public String password;
	public String firsName;
	public String lastName;
	public List<String> roles;
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
		roles.addAll(roles);
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
