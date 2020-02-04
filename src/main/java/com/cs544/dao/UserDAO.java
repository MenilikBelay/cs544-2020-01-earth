package com.cs544.dao;

import com.cs544.domain.User;

public interface UserDAO {
	
	public User getUser (String email);
}
