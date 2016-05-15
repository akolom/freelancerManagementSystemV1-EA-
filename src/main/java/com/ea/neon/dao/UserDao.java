package com.ea.neon.dao;

import com.ea.neon.domain.User;

public interface UserDao extends GenericDao<User> {
      
	public User findByEmail(String email);
}
