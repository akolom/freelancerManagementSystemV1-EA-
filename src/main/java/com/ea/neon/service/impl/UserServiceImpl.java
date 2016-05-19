package com.ea.neon.service.impl;

import java.util.Arrays;
import java.util.List;

import org.hibernate.StaleObjectStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ea.neon.domain.Employer;
import com.ea.neon.domain.Freelancer;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.User;
import com.ea.neon.repository.AddressRepository;
import com.ea.neon.repository.EmployerRepository;
import com.ea.neon.repository.FreelancerRepository;
import com.ea.neon.repository.ProjectRepository;
import com.ea.neon.repository.UserRepository;
import com.ea.neon.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmployerRepository employerRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private FreelancerRepository freelancerRepository;

	@Autowired
	private ProjectRepository projectRepository;

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
		
		//userRepository.update(user);
	
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

	@Override
	public User findUserById(Integer id) {
		User user = userRepository.findOne(id);
		user.getAddresses();
		user.getProfile();
		user.getCredentials();
		return user;
	}

	@Override
	public Employer findEmployerById(Integer id) {
		Employer employer = employerRepository.findOne(id);
		employer.setAddresses(addressRepository.findAllByUser(employer));
		employer.getCredentials();
		employer.getProfile();
		return employer;
	}

	@Override
	public void removeProjectFromFreelancer(Freelancer freelancer, Project project) {
		List<Project> projects = projectRepository.findAllByFreelancers(Arrays.asList(freelancer));
		for (int i = 0; i < projects.size(); i++) {
			if (projects.get(i).getId() == project.getId()) {
				projects.remove(i);
			}
		}
		freelancer.setProjects(projects);
		freelancerRepository.save(freelancer);
	}

}
