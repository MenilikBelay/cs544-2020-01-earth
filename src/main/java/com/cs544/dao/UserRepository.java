package com.cs544.dao;

import org.springframework.data.repository.CrudRepository;

import com.cs544.domain.IUser;
import java.util.Optional;

public interface UserRepository extends CrudRepository<IUser, Long> {
	Optional<IUser> findByEmail (String email);
}
