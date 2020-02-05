package com.cs544.service;

import com.cs544.dao.CourseRepository;
import com.cs544.domain.Course;
import com.cs544.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course add(Course course) {
        courseRepository.save(course);
        return course;
    }



    @Override
    public ResponseEntity<?> deleteCourseById(String id) {
            Course course=  courseRepository.getCourseByCourseID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));

            courseRepository.delete(course);

        return ResponseEntity.ok().build();
    }


    @Override
    public Course update(String id,Course course) {
        Course courses=  courseRepository.getCourseByCourseID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));
        courses.setDescription(course.getDescription());
        courses.setCourseID(course.getCourseID());
        Course courseupdate=  courseRepository.save(courses);
        return courseupdate;
    }

    @Override
    public Course getCourseById(String id) {
        return courseRepository.getCourseByCourseID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));
    }
}
