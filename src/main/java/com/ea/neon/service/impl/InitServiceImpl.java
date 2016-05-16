package com.ea.neon.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ea.neon.domain.Category;
import com.ea.neon.domain.Category.CategoryTitle;
import com.ea.neon.domain.Employer;
import com.ea.neon.domain.Freelancer;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills;
import com.ea.neon.domain.Skills.SkillTitle;
import com.ea.neon.domain.User;
import com.ea.neon.repository.CategoryRepository;
import com.ea.neon.repository.ProjectRepository;
import com.ea.neon.repository.SkillsRepository;
import com.ea.neon.repository.UserRepository;

@Service
@Transactional
public class InitServiceImpl {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	SkillsRepository skillsRepository;
	
	
	@PostConstruct
	public void init(){
		User user = new Freelancer();
		user.setFirstName("steve");
		user.setFirstName("jobs");
		user.setEmail("jobs@gmail.com");
		
		
		userRepo.save(user);
		
		
		Skills skillsAndroid = new Skills();
		skillsAndroid.setSkillTitle(SkillTitle.ANDROID);
		skillsRepository.save(skillsAndroid);
		
		Skills skillsJAVA = new Skills();
		skillsAndroid.setSkillTitle(SkillTitle.JAVA);
		skillsRepository.save(skillsJAVA);	

		List<Skills> skills = new ArrayList<>();
		skills.add(skillsJAVA);
		skills.add(skillsAndroid);
		
		Category category = new Category();
		category.setCategoryTitle(CategoryTitle.MOBILE_PHONES_AND_COMPUTING);
		category.setSkills(skills);
		
		categoryRepository.save(category);
		
		
		Project project = new Project();
		project.setBudget(100.00);
		project.setDescription("app is software as a service system");
		project.setName("App");
		project.setCategory(category);
		
		
		Project project2 = new Project();
		project2.setBudget(10000.00);
		project2.setName("Christmas");
		project2.setDescription("Android App | Social Networking | Design | Lollipop");

		
		
		projectRepo.save(project);

		projectRepo.save(project2);
		
		System.out.println(projectRepo.findBySelections(CategoryTitle.MOBILE_PHONES_AND_COMPUTING, 50.00, 150.00));
		
	}
	
}
