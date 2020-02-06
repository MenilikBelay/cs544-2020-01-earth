package com.cs544.service;

import com.cs544.dao.CourseOfferingRepository;
import com.cs544.dao.CourseRepository;
import com.cs544.domain.Course;
import com.cs544.domain.CourseOffering;
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
    public CourseOffering add(CourseOffering courseOffering, String id) {

        Course course=  courseRepository.getCourseByCourseID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));


            courseOffering.setCourse(course);

         return courseOfferingRepository.save(courseOffering);
    }

    @Override
    public ResponseEntity<?> deleteCourseOfferingById(String id) {
        CourseOffering course=  courseOfferingRepository.getCourseOfferingByCourseOfferingID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));

        courseOfferingRepository.delete(course);

        return ResponseEntity.ok().build();
    }


    @Override
    public CourseOffering update(String id, CourseOffering courseOffering) {

        CourseOffering courses=  courseOfferingRepository.getCourseOfferingByCourseOfferingID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));
        courses.setCourse(courseOffering.getCourse());
        courses.setEndDate(courseOffering.getEndDate());
        courses.setStartDate(courseOffering.getStartDate());
        courses.setSession(courseOffering.getSession());

        CourseOffering courseupdate=  courseOfferingRepository.save(courses);
        return courseupdate;
    }

    @Override
    public CourseOffering getCourseOfferingById(String id) {
        return courseOfferingRepository.getCourseOfferingByCourseOfferingID(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));

    }

    /*@Override
    public CourseOffering getCourseOfferingByCourseId(String id) {
        return  courseOfferingRepository.getCourseOfferingByCourseId(id).orElseThrow(() -> new ResourceNotFoundException("Note", "id",id));
    }*/
}
