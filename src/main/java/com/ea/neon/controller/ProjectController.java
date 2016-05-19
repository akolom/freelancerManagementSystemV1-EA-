package com.ea.neon.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ea.neon.domain.Category;
import com.ea.neon.domain.Category.CategoryTitle;
import com.ea.neon.domain.Freelancer;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills;
import com.ea.neon.domain.Skills.SkillTitle;
import com.ea.neon.domain.Status;
import com.ea.neon.domain.Status.ProjectStatus;
import com.ea.neon.dto.ProjectApplyDTO;
import com.ea.neon.dto.ProjectSearchDTO;
import com.ea.neon.repository.EmployerRepository;
import com.ea.neon.repository.ProjectRepository;
import com.ea.neon.sender.MessageSender;
import com.ea.neon.service.CategoryService;
import com.ea.neon.service.ProjectService;
import com.ea.neon.service.SkillService;
import com.ea.neon.service.StatusService;
import com.ea.neon.service.UserService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	MessageSender messageSender;

	@Autowired
	ProjectService projectService;
	@Autowired
	CategoryService categoryService;

	@Autowired
	SkillService skillService;

	@Autowired
	UserService userService;
	@Autowired
	ProjectRepository projectRepository;

	
	@Autowired
	EmployerRepository employerRepository;
	

	@ModelAttribute("userStory")
	public Project getProject() {
		return new Project();
	}

	@Autowired
	private StatusService statusService;

	@RequestMapping("/hireFreelancer")
	public String hireFreelancer(@RequestParam("f_id") Integer freelancerId, @RequestParam("p_id") Integer projectId,
			Model model) {

		Project project = projectService.getProjectById(projectId);
		Freelancer freelancer = (Freelancer) userService.findUserById(freelancerId);

		Status status = statusService.getStatusByProjectStatus(ProjectStatus.ACCEPTED);

		project.setStatus(status);

		for (Freelancer f : project.getFreelancers()) {
			if (f.getId() != freelancerId) {
				userService.removeProjectFromFreelancer(f, project);
			}
		}

		project.getFreelancers().clear();

		project.getFreelancers().add(freelancer);

		projectService.updateProject(project);

		return "redirect:/email/forHiring.html?f_id=" + freelancerId + "&&p_id=" + projectId;
	}

	@RequestMapping(value = "/projects/all", method = RequestMethod.GET)
	public String listProjects(Model model) {
		model.addAttribute("category", categoryService.findAll());
		model.addAttribute("skill", skillService.findAll());
		model.addAttribute("listProject", projectService.findAll(19));
		return "project_read";
	}

	@RequestMapping(value = "/projects/freelancer_project", method = RequestMethod.GET)
	public String freelancerProject(Model model) {
		model.addAttribute("listProject", projectService.findAllAppliedProjects(19));
		return "freelancer_project";
	}

	@ModelAttribute("projectSearch")
	public ProjectSearchDTO projectSearchDetails() {
		return new ProjectSearchDTO();
	}

	@RequestMapping(value = "/projects/applyProject", method = RequestMethod.GET)
	public String applyProject(@RequestParam Integer id) {

		Project project = projectService.findById(id);

		Freelancer akolom = new Freelancer();

		akolom.setFirstName("ako");
		akolom.setLastName("sa");
		userService.save(akolom);
		ProjectApplyDTO projectApplyDTO = new ProjectApplyDTO();
		projectApplyDTO.setFreelancer(akolom);
		projectApplyDTO.setProject(project);
		messageSender.sendMessage(projectApplyDTO);

		return "redirect:freelancer_project.html";
	}

	@RequestMapping(value = "/projects/search", method = RequestMethod.GET)
	public String searchProjects(Model model, @RequestParam String search) {
		model.addAttribute("category", categoryService.findAll());
		model.addAttribute("skill", skillService.findAll());
		model.addAttribute("listProject", projectService.findAllNotAppliedprojects(search, 19));
		return "project_read";
	}

	@RequestMapping(value = "/projects/filterSearch", method = RequestMethod.POST)
	public String filterSearch(Model model, @ModelAttribute("projectSearch") ProjectSearchDTO projectSearchDTO) {
		CategoryTitle categoryTitle = projectSearchDTO.getCategory().getCategoryTitle();
		List<SkillTitle> skills = new ArrayList<>();
		for (Skills s : projectSearchDTO.getSkills()) {
			skills.add(s.getSkillTitle());
		}

		Double maxBudget = projectSearchDTO.getMaxBudget();

		model.addAttribute("category", categoryService.findAll());
		model.addAttribute("skill", skillService.findAll());

		model.addAttribute("listProject", projectService.findAllByFilter(19, skills, categoryTitle, 1.0, maxBudget));
		return "project_read";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
	}

	public class CategoryEditor extends PropertyEditorSupport {

		private final CategoryService categoryService;

		public CategoryEditor(CategoryService categoryService) {
			this.categoryService = categoryService;
		}

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			try {
				Category category = categoryService.getCategoryById(Integer.parseInt(text));
				setValue(category);
			} catch (NumberFormatException e) {
				setValue(null);
			}

		}
	}

	@InitBinder
	public void skillsBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(List.class, "skills", new CustomCollectionEditor(List.class) {

			protected Object convertElement(Object element) {
				if (element != null) {
					Integer id = Integer.parseInt(element.toString());
					Skills skill = skillService.getSkillById(id);
					return skill;
				}
				return null;
			}
		});
	}

}
