package com.ea.neon.controller;

import java.beans.PropertyEditorSupport;
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
import com.ea.neon.domain.Employer;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills;
import com.ea.neon.domain.Skills.SkillTitle;
import com.ea.neon.service.CategoryService;
import com.ea.neon.service.ProjectService;
import com.ea.neon.service.SkillService;
import com.ea.neon.service.UserService;

@Controller
@RequestMapping(value = "/employer")
public class EmployerController {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private SkillService skillService;

	@ModelAttribute("newProject")
	public Project getProject() {
		return new Project();
	}

	@RequestMapping(value = "/profile")
	public String viewProfile(@RequestParam("id") Integer id, Model model) {
		Employer employer = userService.findEmployerById(id);
		List<Project> projects = projectService.findAllByEmployer(employer);
		employer.setProject(projects);
		model.addAttribute("currentUser", employer);
		model.addAttribute("categories", categoryService.findAll());
		return "demoEmployerProfile";
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public String addProject(@ModelAttribute("newProject") Project project) {
		project.setEmployer(userService.findEmployerById(4));
		projectService.saveProject(project);
		return "redirect:/employer/profile.html?id=4";
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
					Skills skill = new Skills();
					try {
						Integer id = Integer.parseInt(element.toString());
						skill = skillService.getSkillById(id);
					} catch (NumberFormatException e) {
						skill = skillService.getSkillBySkillTitle(SkillTitle.valueOf(element.toString()));
					}
					return skill;
				}
				return null;
			}
		});
	}

}
