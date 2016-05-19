package com.ea.neon.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ea.neon.domain.Freelancer;
import com.ea.neon.service.ProjectService;
import com.ea.neon.service.UserService;

@Controller
@RequestMapping(value = "/freelancer")
public class FreelancerController {

	@Autowired
	private UserService userService;

	@Autowired
	private ProjectService projectService;

	

	@RequestMapping(value = "/profile")
	public String viewProfile(Model model,Principal principal) {

		Freelancer freelancer = userService.findFreelancerByUserName(principal.getName());
		model.addAttribute("listProject", projectService.findAllAppliedProjects(freelancer.getId()));
		model.addAttribute("currentUser", freelancer);
		return "freelancer_profile";
	}
	

}
