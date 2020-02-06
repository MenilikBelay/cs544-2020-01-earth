package com.cs544.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.cs544.domain.CourseOffering;
import com.cs544.domain.Register;
import com.cs544.domain.Student;

public interface RegisterRepository extends CrudRepository<Register, Long> {
	public Optional<Register> findByCourseOfferingAndStudent(CourseOffering courseOffering, Student student);
}
