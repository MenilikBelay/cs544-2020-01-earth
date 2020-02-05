package com.cs544.service;

import com.cs544.domain.OfferedCourse;
import org.springframework.http.ResponseEntity;

public interface CourseofferingService {

    public OfferedCourse add(OfferedCourse course, String id);
    public ResponseEntity<?> deleteCourseById(String id);

    public OfferedCourse update(String id,OfferedCourse offeredCourse);
    public OfferedCourse getCourseOfferingById(String id);
}
