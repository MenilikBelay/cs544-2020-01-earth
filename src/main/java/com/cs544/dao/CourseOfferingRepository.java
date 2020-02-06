package com.cs544.dao;

import com.cs544.domain.CourseOffering;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseOfferingRepository extends CrudRepository<CourseOffering,Long> {

    public Optional<CourseOffering> getCourseOfferingByCourseOfferingID(String id);
  //  public Optional<CourseOffering> getCourseOfferingByCourseId (String id);


}
