package com.cs544.dao;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.repository.CrudRepository;

import com.cs544.domain.Person;
import java.util.Optional;

import javax.validation.Valid;

public interface PersonRepository extends CrudRepository<Person, Long> {
	Optional<@Valid Person> findByEmail ( String email);
}
