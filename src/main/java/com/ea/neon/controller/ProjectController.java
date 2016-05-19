package com.ea.neon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ea.neon.domain.Freelancer;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Status;
import com.ea.neon.domain.Status.ProjectStatus;
import com.ea.neon.service.ProjectService;
import com.ea.neon.service.StatusService;
import com.ea.neon.service.UserService;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userService;

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

}
