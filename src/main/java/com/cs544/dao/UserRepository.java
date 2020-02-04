package com.cs544.dao;

import org.springframework.data.repository.CrudRepository;

import com.cs544.domain.User;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByEmail (String email);
}
