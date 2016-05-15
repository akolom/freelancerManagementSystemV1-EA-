package com.ea.neon.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ea.neon.domain.Project;
import com.ea.neon.domain.User;
import com.ea.neon.repository.ProjectRepository;
import com.ea.neon.repository.UserRepository;

@Service
@Transactional
public class InitServiceImpl {

	@Autowired
	UserRepository userRepo;
	ProjectRepository projectRepo;
	
	@PostConstruct
	public void init(){
		User user = new User();
		user.setFirstName("steve");
		user.setFirstName("jobs");
		user.setEmail("jobs@gmail.com");
		
		userRepo.save(user);
		
		
		Project project = new Project();
		project.setBudget("121");
		project.setName("App");
		
		
		Project project2 = new Project();
		project.setBudget("1212");
		project.setName("Appa");

		
		
		projectRepo.save(project);

		projectRepo.save(project2);
		
	}
	
}
