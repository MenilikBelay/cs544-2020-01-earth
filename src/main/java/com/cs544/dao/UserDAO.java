package com.cs544.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cs544.domain.IUser;

@Repository
public class UserDAO implements IUserDAO {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public IUser getUser (String email) {
		return userRepository.findByEmail(email).orElse(null);
	}
}
