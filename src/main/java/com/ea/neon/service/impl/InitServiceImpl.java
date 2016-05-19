package com.ea.neon.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
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
import com.ea.neon.service.ProjectService;
import com.ea.neon.service.UserService;

@Service
@Transactional
public class InitServiceImpl {

	@Autowired
	UserRepository userRepo;

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	ProjectService projectService;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SkillsRepository skillsRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Autowired
	UserService userService;

	@PostConstruct
	public void init() {

		Profile profile = new Profile();
		profile.setProfessionalHeadLine("I am an employer. I will post my projects for freelancers");
		profile.setProfileSummary("This is a test profile of an employer.");

		Authority authority = new Authority();
		authority.setName("Employer");
		authority.setRole("ROLE_EMP");

		authorityRepository.save(authority);

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		Credentials credentials = new Credentials();
		credentials.setUserName("employer");
		credentials.setPassword(encoder.encode("employer"));
		credentials.setAuthority(authority);

		User employer = new Employer();
		employer.setFirstName("employer");
		employer.setLastName("employer");
		employer.setEmail("employer@gmail.com");
		employer.setProfile(profile);
		employer.setCredentials(credentials);

		userRepo.save(employer);

		User user = new Freelancer();
		user.setFirstName("steve");
		user.setFirstName("jobs");
		user.setEmail("jobs@gmail.com");

		userRepo.save(user);

		Skills skillsAndroid = new Skills();
		skillsAndroid.setSkillTitle(SkillTitle.ANDROID);
		skillsRepository.save(skillsAndroid);

		Skills skillsJAVA = new Skills();
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

		project.setEmployer((Employer) employer);
		Employer emp = project.getEmployer();
		emp.setProjectCompleted(1);
		project2.setEmployer(emp);
		emp.setProjectCompleted(emp.getProjectCompleted() + 1);

		userRepo.save(emp);

		projectService.saveProject(project);

		projectService.saveProject(project2);

		freelancer.setProjects(Arrays.asList(project));

		userRepo.save(freelancers);

		Project toBeDeleted = new Project();
		toBeDeleted.setName("To Be Deleted");
		toBeDeleted.setCategory(category);
		toBeDeleted.setBudget(100.00);
		projectService.saveProject(toBeDeleted);

		Freelancer akolom = new Freelancer();

		akolom.setFirstName("ako");
		akolom.setLastName("sa");
		userService.save(akolom);

		userService.saveFreelancerInProject(project, akolom);

		List<Integer> idsss = new ArrayList<>();
		idsss.add(17);
		idsss.add(14);

		List<SkillTitle> skillTitles = new ArrayList<>();
		skillTitles.add(SkillTitle.ANDROID);
		skillTitles.add(SkillTitle.JAVA);

	}

}
