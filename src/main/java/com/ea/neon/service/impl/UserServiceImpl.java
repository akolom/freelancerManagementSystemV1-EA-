package com.ea.neon.service.impl;

import java.util.List;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ea.neon.dao.UserDao;
import com.ea.neon.domain.User;
import com.ea.neon.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;


	public void save(User user) {
		
  		
		userDao.save(user);
	}
	public List<User> findAll() {
		return (List<User>) userDao.findAll();
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	public User update(User user) {
		try {
			return userDao.update(user);
		} catch (StaleObjectStateException e) {
			System.out.println(e);
			return null;
		}
	}

	public User testRefresh(User user) {
		user.setEmail("Lotta@Doe.com");
		userDao.save(user);

		return user;
	}

}
