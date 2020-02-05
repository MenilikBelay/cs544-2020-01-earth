package com.cs544.dao;

import com.cs544.domain.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course,Long> {

    public Optional<Course> getCourseByCourseID(String id);


}
