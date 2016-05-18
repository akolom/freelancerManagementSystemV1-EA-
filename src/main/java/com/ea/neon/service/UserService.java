package com.ea.neon.service;

import java.util.List;

import com.ea.neon.domain.User;

public interface UserService {

	public void save(User user);

	public List<User> findAll();

	public User findByEmail(String email);

	public User update(User user);

	public User findOneByUsername(String userName);
}
