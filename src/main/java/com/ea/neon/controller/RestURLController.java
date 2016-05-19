package com.ea.neon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ea.neon.domain.Category;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills;
import com.ea.neon.dto.ProjectDTO;
import com.ea.neon.service.CategoryService;
import com.ea.neon.service.ProjectService;

@Controller
@RequestMapping("/rest")
public class RestURLController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping(value = "/getSkills/{cat_id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody List<Skills> getSkills(@PathVariable("cat_id") Integer categoryId) {
		Category category = categoryService.getCategoryById(categoryId);
		return category.getSkills();
	}
	
	@RequestMapping(value = "/getProject/{project_id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody ProjectDTO getProject(@PathVariable("project_id") Integer projectId) {
		Project project = projectService.getProjectById(projectId);
		ProjectDTO projectDTO = new ProjectDTO();
		projectDTO.setId(project.getId());
		projectDTO.setName(project.getName());
		projectDTO.setDescription(project.getDescription());
		projectDTO.setCategory(project.getCategory());
		projectDTO.setSkills(project.getSkills());
		return projectDTO;
	}

}
