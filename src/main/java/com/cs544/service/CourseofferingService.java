package com.cs544.service;

import com.cs544.domain.CourseOffering;
import com.cs544.domain.Register;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface CourseofferingService {

    public CourseOffering add(CourseOffering course, String id);
    public ResponseEntity<?> deleteCourseOfferingById(String id);

    public CourseOffering update(String id, CourseOffering courseOffering);
    public CourseOffering getCourseOfferingById(String id);
    
	String getCourseOfferingAttendances(String courseOfferingId);
	List<Optional<Register>> getRegisteredStudents(String courseOffering);
  //  public CourseOffering getCourseOfferingByCourseId(String id);

}
