package com.cs544.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.dao.PersonRepository;
import com.cs544.domain.Person;
import com.cs544.domain.Role;
import com.cs544.domain.Student;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personDao;
	
	/**
	 * Return a student if found
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Optional<Student> getStudentFromEmail(String email) {
		Optional<Person> personOptional = personDao.findByEmail(email);
		if (personOptional.isEmpty())
			return null;
		Person person = personOptional.get();
		return person.getPersonRoles().stream()
			.filter(p -> p.getRole() == Role.STUDENT)
			.findAny() // I am sure it will be Student from this line onwards 
			.map(pr -> (Student) pr);
	}

}
