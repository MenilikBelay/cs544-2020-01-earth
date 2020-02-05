package com.cs544.dao;

import org.springframework.data.repository.CrudRepository;

import com.cs544.domain.Person;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
	Optional<Person> findByEmail (String email);
}
