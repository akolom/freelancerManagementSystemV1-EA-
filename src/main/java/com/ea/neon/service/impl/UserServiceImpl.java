package com.ea.neon.service.impl;

import java.util.List;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ea.neon.domain.User;
import com.ea.neon.repository.UserRepository;
import com.ea.neon.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		userRepository.save(user);
	}
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	public User update(User user) {
		try {
			return userRepository.save(user);
		} catch (StaleObjectStateException e) {
			System.out.println(e);
			return null;
		}
	}
	@Override
	public User findOneByUsername(String userName) {
		return userRepository.findOneByCredentialsUserName(userName);
	}

}
