package com.cs544.dao;

import com.cs544.domain.CourseOffering;
import com.cs544.domain.Register;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegisterRepository extends CrudRepository<Register,Long> {

    public List<Optional<Register>> findByCourseOffering(CourseOffering courseOffering);

}
