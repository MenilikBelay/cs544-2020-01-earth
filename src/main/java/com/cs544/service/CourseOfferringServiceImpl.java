package com.cs544.service;

import com.cs544.dao.CourseOfferingRepository;
import com.cs544.dao.CourseRepository;
import com.cs544.domain.Course;
import com.cs544.domain.CourseOffering;
import com.cs544.exception.ResourceNotFoundException;

import javax.validation.Valid;

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
    public CourseOffering add(@Valid CourseOffering courseOffering, String id) {

        Course course=  courseRepository.getCourseByCourseID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));


            courseOffering.setCourse(course);

         return courseOfferingRepository.save(courseOffering);
    }

    @Override
    public ResponseEntity<?> deleteCourseOfferingById(String id) {
        CourseOffering course=  courseOfferingRepository.getOfferedCourseByCourseOfferingID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));

        courseOfferingRepository.delete(course);

        return ResponseEntity.ok().build();
    }


    @Override
    public CourseOffering update(String id, @Valid CourseOffering courseOffering) {
        return null;
    }

    @Override
    public CourseOffering getCourseOfferingById(String id) {
        return courseOfferingRepository.getOfferedCourseByCourseOfferingID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));

    }
}
