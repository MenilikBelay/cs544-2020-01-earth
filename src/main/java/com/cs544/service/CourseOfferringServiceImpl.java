package com.cs544.service;

import com.cs544.dao.CourseOfferingRepository;
import com.cs544.dao.CourseRepository;
import com.cs544.domain.Course;
import com.cs544.domain.OfferedCourse;
import com.cs544.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseOfferringServiceImpl implements  CourseofferingService {
@Autowired
    CourseOfferingRepository courseOfferingRepository;
@Autowired
    CourseRepository courseRepository;
    @Override
    public OfferedCourse add(OfferedCourse courseOffering, String id) {

        Course course=  courseRepository.getCourseByCourseID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));


            courseOffering.setCourse(course);

         return courseOfferingRepository.save(courseOffering);
    }

    @Override
    public ResponseEntity<?> deleteCourseById(String id) {
        return null;
    }

    @Override
    public OfferedCourse update(String id, OfferedCourse offeredCourse) {
        return null;
    }

    @Override
    public OfferedCourse getCourseOfferingById(String id) {
        return null;
    }
}
