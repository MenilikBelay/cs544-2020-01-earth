package com.cs544.dao;

import com.cs544.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDAOimpl implements UserDAO {
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public User getUser(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}
}
