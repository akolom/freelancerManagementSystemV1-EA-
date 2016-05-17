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
import com.ea.neon.repository.CredentialsRepository;
import com.ea.neon.repository.ProfileRepository;
import com.ea.neon.repository.ProjectRepository;
import com.ea.neon.repository.SkillsRepository;
import com.ea.neon.repository.UserRepository;
import com.ea.neon.service.UserService;

@Service
@Transactional
public class InitServiceImpl {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	SkillsRepository skillsRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private CredentialsRepository credentialsRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@PostConstruct
	public void init() {

		Profile profile = new Profile();
		profile.setProfessionalHeadLine("I am an employer. I will post my projects for freelancers");
		profile.setProfileSummary("This is a test profile of an employer.");

		profileRepository.save(profile);

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
		
		Freelancer keshav = new Freelancer();
		keshav.setFirstName("Keshav");
		keshav.setLastName("Shai");
		userRepo.save(keshav);
		
		Freelancer sabeen = new Freelancer();
		sabeen.setFirstName("Sabeen");
		sabeen.setLastName("Pradhan");
		sabeen.setProjects(new ArrayList<>());
		userRepo.save(sabeen);
		
		List<Freelancer> freelancers = new ArrayList<>();
		freelancers.add(sabeen);
		freelancers.add(keshav);
		
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

		Freelancer freelancer = new Freelancer();
		freelancer.setFirstName("freelancer");


		skillsJAVA.setSkillTitle(SkillTitle.JAVA);
		skillsRepository.save(skillsJAVA);	
		

		Skills skillsGraphic = new Skills();
		skillsGraphic.setSkillTitle(SkillTitle.GRAPHIC_DESIGN);
		skillsRepository.save(skillsGraphic);
		

		List<Skills> skillsJAVAandAndroid = new ArrayList<>();
		skillsJAVAandAndroid.add(skillsJAVA);
		skillsJAVAandAndroid.add(skillsAndroid);
		
		List<Skills> skillsGraphics = new ArrayList<>();
		skillsGraphics.add(skillsGraphic);
		
		
		List<SkillTitle> skillTitlesAndroidJAVA = new ArrayList<>();
		skillTitlesAndroidJAVA.add(SkillTitle.ANDROID);
		skillTitlesAndroidJAVA.add(SkillTitle.JAVA);
		
		List<SkillTitle> skillTitlesGraphic = new ArrayList<>();
		skillTitlesGraphic.add(SkillTitle.GRAPHIC_DESIGN);
		categoryRepository.save(category);
		
		Category category2 = new Category();
		category2.setCategoryTitle(CategoryTitle.WEBSITE_IT_AND_SOFTWARE);
		category2.setSkills(skillsGraphics);
		
		categoryRepository.save(category2);
		
		Project project = new Project();
		project.setBudget(100.00);
		project.setDescription("Android App | SAAS | Lollipop");
		project.setName("Android Devlopment");
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

		projectRepo.save(project);

		projectRepo.save(project2);

		freelancer.setProjects(Arrays.asList(project));

		userRepo.save(freelancers);

		project2.setName("Graphic Design");
		project2.setDescription("Graphic Design | UI | UX | Lollipop");
		project2.setCategory(category2);
		project2.setFreelancers(freelancers);
		
		projectRepo.save(project);

		projectRepo.save(project2);
		
		List<Project> projects = new ArrayList<>();
		projects.add(project);
		projects.add(project2);
//		System.out.println((projectRepo.findBySelections(skillTitlesAndroidJAVA, 
//				CategoryTitle.MOBILE_PHONES_AND_COMPUTING, 50.00, 900.00).get(0).getName())+" : Titles");
		
		List<Project> results = projectRepo.findByDescAndTitle("Lollipop");
		for(Project resultProject : results){

			System.out.println("Project Title : "+resultProject.getName());
		}
		
		
		userService.saveFreelancerInProject(project, sabeen);
		userService.saveFreelancerInProject(project2, sabeen);
		
	}

}
