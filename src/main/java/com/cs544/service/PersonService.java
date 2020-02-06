package com.cs544.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cs544.domain.Student;

@Service
public interface PersonService {
	/**
	 * Get Student object if user with the given 'email'
	 * has STUDENT role
	 * @param email email of the user
	 * @return Optional of Student object
	 */
	public Optional<Student> getStudentFromEmail (String email);
}
