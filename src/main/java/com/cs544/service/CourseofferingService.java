package com.cs544.service;

import com.cs544.domain.CourseOffering;
import org.springframework.http.ResponseEntity;

public interface CourseofferingService {

    public CourseOffering add(CourseOffering course, String id);
    public ResponseEntity<?> deleteCourseOfferingById(String id);

    public CourseOffering update(String id, CourseOffering courseOffering);
    public CourseOffering getCourseOfferingById(String id);
}
