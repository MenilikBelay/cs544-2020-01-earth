package com.cs544.domain;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends IUser {

	private List<OfferingCourses> offerCourses ;

	public Faculty() {}
	public Faculty(String email ,String password , String firstName,String lastName,List<String>roles ) {
		super(email, password, firstName, lastName, roles );
		offerCourses = new ArrayList<OfferingCourses>();
	}

	public void addOfferingCourse(List<OfferingCourses> offerCourse)
	{
		offerCourses.addAll(offerCourse);
	}
	
	public List<OfferingCourses> getOfferCourses() {
		return offerCourses;
	}

	public void setOfferCourses(List<OfferingCourses> offerCourses) {
		this.offerCourses = offerCourses;
	}
	
}