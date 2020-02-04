package com.cs544.domain;



import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "adminstrator")
public class Admin extends User {
	
	public Admin() {}
	
	public Admin(String email ,String password , String firstName,String lastName,List<Role>roles ) {
		super(email, password, firstName, lastName,roles);
		}

}
