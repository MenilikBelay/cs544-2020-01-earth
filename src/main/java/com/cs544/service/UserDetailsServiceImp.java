package com.cs544.service;

import com.cs544.dao.UserDAO;
import com.cs544.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private UserDAO userDAO;
	
	public void setUserdao(UserDAO userdao) {
		this.userDAO = userdao;
	}
	
	/**
	 * Username acts like the email
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDAO.getUser(username);
		UserBuilder builder = null;
	    if (user != null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(username);
	      builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
	      builder.roles(user.getRoles().parallelStream()
	    		  .map(role -> role.toString())
	    		  .collect(Collectors.toList())
	    		  .toArray(new String[0]));	// convert to list of strings and then to array
	    } else {
	      throw new UsernameNotFoundException("User Not Found.");
	    }

	    return builder.build();
	}

}
