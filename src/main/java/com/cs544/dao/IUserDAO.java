package com.cs544.dao;

import com.cs544.domain.IUser;

public interface IUserDAO {
	
	public IUser getUser (String email);
}
