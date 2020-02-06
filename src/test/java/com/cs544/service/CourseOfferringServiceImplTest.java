package com.cs544.service;

import com.cs544.dao.CourseOfferingRepository;
import com.cs544.dao.CourseRepository;
import com.cs544.domain.Course;
import com.cs544.domain.CourseOffering;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@Transactional
class CourseOfferringServiceImplTest {
        @Mock
        CourseOfferingRepository courseOfferingRepository;
        @Mock
        CourseRepository courseRepository;
        @InjectMocks
        CourseOfferringServiceImpl courseOfferringService;
         private final String courseOfferingId="cs544-01";
        Course courses;
    @BeforeEach
    public void startup() throws Exception{
        MockitoAnnotations.initMocks(this);
        this.courses=new Course();
        courses.setCourseID("cs544");
        courses.setDescription("ea course");



    }
    @Test
    void add() {
       when(courseRepository.getCourseByCourseID(anyString())).thenReturn(java.util.Optional.ofNullable(courses));
        CourseOffering courseOffering=new CourseOffering();

        courseOffering.setStartDate(new Date());
        courseOffering.setEndDate(new Date());
        courseOffering.setCourseOfferingID("cs544-01");
        courseOffering.setCourse(courses);
        courseOffering.setId(9L);
        courseOfferringService.add(courseOffering,"cs544");
        verify(courseOfferingRepository,times(1)).save(courseOffering);

    }

    @Test
    void deleteCourseOfferingById() {
    }

    @Test
    void update() {
    }

    @Test
    void getCourseOfferingById() {

        CourseOffering courseOffering=new CourseOffering();

        courseOffering.setStartDate(new Date());
        courseOffering.setEndDate(new Date());
        courseOffering.setCourseOfferingID("cs544-01");
        courseOffering.setCourse(courses);
        courseOffering.setId(9L);
        when(courseOfferingRepository.getCourseOfferingByCourseOfferingID(anyString())).thenReturn(java.util.Optional.of(courseOffering));
       CourseOffering courseOffering1= courseOfferringService.getCourseOfferingById("cs544-01");
       assertNotNull(courseOffering1);
       assertEquals("cs544-01",courseOffering1.getCourseOfferingID());
    }
}