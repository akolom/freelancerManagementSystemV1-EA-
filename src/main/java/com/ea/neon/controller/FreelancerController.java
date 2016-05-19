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
import com.ea.neon.domain.Freelancer;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills;
import com.ea.neon.service.CategoryService;
import com.ea.neon.service.ProjectService;
import com.ea.neon.service.SkillService;
import com.ea.neon.service.UserService;

@Controller
@RequestMapping(value = "/freelancer")
public class FreelancerController {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private SkillService skillService;

	@Autowired
	private ProjectService projectService;

	

	@RequestMapping(value = "/profile")
	public String viewProfile(@RequestParam("id") Integer id, Model model) {
		Freelancer freelancer = userService.findFreelancerById(id);
//		List<Project> projects = projectService.findAllByEmployer(employer);
//		employer.setProject(projects);
		model.addAttribute("listProject", projectService.findAllAppliedProjects(19));
		model.addAttribute("currentUser", freelancer);
		return "freelancer_profile";
	}
	

}
