package com.cs544.dao;

import com.cs544.domain.Person;
import org.springframework.data.repository.CrudRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
	Optional<@Valid Person> findByEmail ( String email);
	List<Person> findAll();

	//Optional<@Valid Person> save(Person person);
}
