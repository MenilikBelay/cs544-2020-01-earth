package com.cs544.service;

import com.cs544.domain.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {

    public Course add(Course course);
    public ResponseEntity<?> deleteCourseById(String id);

    public Course update(String id,Course course);
    public Course getCourseById(String id);
}
