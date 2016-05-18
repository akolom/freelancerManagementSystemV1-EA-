package com.ea.neon.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ea.neon.domain.Authority;
import com.ea.neon.domain.Category;
import com.ea.neon.domain.Category.CategoryTitle;
import com.ea.neon.domain.Credentials;
import com.ea.neon.domain.Employer;
import com.ea.neon.domain.Freelancer;
import com.ea.neon.domain.Profile;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills;
import com.ea.neon.domain.Skills.SkillTitle;
import com.ea.neon.domain.User;
import com.ea.neon.repository.AuthorityRepository;
import com.ea.neon.repository.CategoryRepository;
import com.ea.neon.repository.ProjectRepository;
import com.ea.neon.repository.SkillsRepository;
import com.ea.neon.repository.UserRepository;
import com.ea.neon.service.AuthorityService;
import com.ea.neon.service.CredentialService;

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

	private AuthorityRepository authorityRepository;

	@Autowired
	private CredentialService credentialService;

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
		Authority adminAuthority = new Authority();
		adminAuthority.setRole("ROLE_ADMIN");
		adminAuthority.setName("ADMIN");
		authorityRepository.save(adminAuthority);

		Credentials admin = new Credentials();
		admin.setUserName("admin");
		admin.setPassword("admin");
		admin.setEnabled(true);
		admin.setAuthority(adminAuthority);
		credentialService.saveCredential(admin);

		Profile profile = new Profile();
		profile.setProfessionalHeadLine("I am an employer. I will post my projects for freelancers");
		profile.setProfileSummary("This is a test profile of an employer.");

		Authority authority1 = new Authority();
		authority1.setName("Employer");
		authority1.setRole("ROLE_EMP");

		authorityRepository.save(authority1);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Credentials credentials = new Credentials();
		credentials.setUserName("employer");
		credentials.setPassword(encoder.encode("employer"));
		credentials.setAuthority(authority1);

		User employer = new Employer();
		employer.setFirstName("employer");
		employer.setLastName("employer");
		employer.setEmail("employer@gmail.com");
		employer.setProfile(profile);
		employer.setCredentials(credentials);

		userRepo.save(employer);

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

		userRepo.save(user);

		Skills skillsAndroid = new Skills();
		skillsAndroid.setSkillTitle(SkillTitle.ANDROID);
		skillsRepository.save(skillsAndroid);

		Skills skillsJAVA = new Skills();
		skillsAndroid.setSkillTitle(SkillTitle.JAVA);
		skillsJAVA.setSkillTitle(SkillTitle.JAVA);
		skillsRepository.save(skillsJAVA);

		List<Skills> skills = new ArrayList<>();
		skills.add(skillsJAVA);
		skills.add(skillsAndroid);

		Category category = new Category();
		category.setCategoryTitle(CategoryTitle.MOBILE_PHONES_AND_COMPUTING);
		category.setSkills(skills);

		categoryRepository.save(category);

		Skills skillsHTML = new Skills();
		skillsHTML.setSkillTitle(SkillTitle.HTML_HTML5);
		skillsRepository.save(skillsHTML);

		Skills skillsPHP = new Skills();
		skillsPHP.setSkillTitle(SkillTitle.PHP);
		skillsRepository.save(skillsPHP);

		List<Skills> skills1 = new ArrayList<>();
		skills1.add(skillsHTML);
		skills1.add(skillsPHP);

		Category category1 = new Category();
		category1.setCategoryTitle(CategoryTitle.WEBSITE_IT_AND_SOFTWARE);
		category1.setSkills(skills1);

		categoryRepository.save(category1);

		Freelancer freelancer = new Freelancer();
		freelancer.setFirstName("freelancer");

		List<Freelancer> freelancers = Arrays.asList(freelancer);

		Project project = new Project();
		project.setBudget(100.00);
		project.setDescription("app is software as a service system");
		project.setName("App");
		project.setCategory(category);
		project.setFreelancers(freelancers);

		Project project2 = new Project();
		project2.setBudget(10000.00);
		project2.setName("Christmas");
		project2.setDescription("Android App | Social Networking | Design | Lollipop");

		List<Authority> authority11 = authorityService.findAll();
		// authority1.add(authority);
		Iterator<Authority> it = authority11.iterator();
		while (it.hasNext()) {

			System.out.println("Authority: " + it.next().getName());
		}
		project.setEmployer((Employer) employer);
		Employer emp = project.getEmployer();
		emp.setProjectCompleted(1);
		project2.setEmployer(emp);
		emp.setProjectCompleted(emp.getProjectCompleted() + 1);

		userRepo.save(emp);

		projectRepo.save(project);

		projectRepo.save(project2);

		System.out.println(projectRepo.findBySelections(CategoryTitle.MOBILE_PHONES_AND_COMPUTING, 50.00, 150.00));
		freelancer.setProjects(Arrays.asList(project));

		userRepo.save(freelancers);

	}

}
