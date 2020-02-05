package com.cs544.dao;

import com.cs544.domain.OfferedCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseOfferingRepository extends CrudRepository<OfferedCourse,Long> {

  //  public Optional<OfferedCourse> getOfferedCourseByOfferingCourseID (String id);


}
