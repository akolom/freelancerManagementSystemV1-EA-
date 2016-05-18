package com.ea.neon.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ea.neon.domain.Authority;
import com.ea.neon.domain.Category;
import com.ea.neon.domain.Category.CategoryTitle;
import com.ea.neon.domain.Credentials;
import com.ea.neon.domain.Freelancer;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills;
import com.ea.neon.domain.Skills.SkillTitle;
import com.ea.neon.domain.User;
import com.ea.neon.repository.CategoryRepository;
import com.ea.neon.repository.ProjectRepository;
import com.ea.neon.repository.SkillsRepository;
import com.ea.neon.repository.UserRepository;
import com.ea.neon.service.AuthorityService;

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

	@Autowired
	AuthorityService authorityService;

	@PostConstruct
	public void init() {

		Authority authority = new Authority();
		authority.setName("Employer");
		authority.setRole("ROLE_EMPLOYER");

		Authority authority2 = new Authority();
		authority2.setName("Freelancer");
		authority2.setRole("ROLE_FREELANCER");
		
		Authority authority3 = new Authority();
		authority3.setName("Admin");
		authority3.setRole("ROLE_ADMIN");

		Credentials credential = new Credentials();
		credential.setAuthority(authority);
		credential.setPassword("steve");
		credential.setVerifyPassword("steve");
		credential.setUserName("steve");

		User user = new Freelancer();
		user.setFirstName("steve");
		user.setLastName("james");
		user.setEmail("jobs@gmail.com");
		user.setCredentials(credential);
		
		userRepo.save(user);
		
		Credentials credential2 = new Credentials();
		credential2.setAuthority(authority2);
		credential2.setPassword("sean");
		credential2.setVerifyPassword("sean");
		credential2.setUserName("sean");

		User user2 = new Freelancer();
		user2.setFirstName("sean");
		user2.setLastName("miki");
		user2.setEmail("seanmiki@gmail.com");
		user2.setCredentials(credential2);
		userRepo.save(user2);
		
		Credentials credential3 = new Credentials();
		credential3.setAuthority(authority3);
		credential3.setPassword("michael");
		credential3.setVerifyPassword("michael");
		credential3.setUserName("michael");

		User user3 = new Freelancer();
		user3.setFirstName("Michael");
		user3.setLastName("Sami");
		user3.setEmail("michael@gmail.com");
		user3.setCredentials(credential3);
		userRepo.save(user3);

		

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

		List<Authority> authority1 = authorityService.findAll();
		// authority1.add(authority);
		Iterator<Authority> it = authority1.iterator();
		while (it.hasNext()) {

			System.out.println("Authority: " + it.next().getName());
		}
		projectRepo.save(project);

		projectRepo.save(project2);

		System.out.println(projectRepo.findBySelections(CategoryTitle.MOBILE_PHONES_AND_COMPUTING, 50.00, 150.00));

	}

}
