package com.cs544.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Faculty extends Person {

	@OneToMany
	private List<CourseOffering> offerCourses ;

	public Faculty() {}
	public Faculty(String email ,String password , String firstName,String lastName,List<Role>roles ) {
		super(email, password, firstName, lastName, roles );
		offerCourses = new ArrayList<CourseOffering>();
	}

	public void addOfferingCourse(List<CourseOffering> offerCourse)
	{
		offerCourses.addAll(offerCourse);
	}
	
	public List<CourseOffering> getOfferCourses() {
		return offerCourses;
	}

	public void setOfferCourses(List<CourseOffering> offerCourses) {
		this.offerCourses = offerCourses;
	}
	
}
