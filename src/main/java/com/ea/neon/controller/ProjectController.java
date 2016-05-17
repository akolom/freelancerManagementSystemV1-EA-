package com.ea.neon.controller;

import java.beans.PropertyEditorSupport;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills;
import com.ea.neon.domain.Skills.SkillTitle;
import com.ea.neon.dto.ProjectSearchDTO;
import com.ea.neon.service.CategoryService;
import com.ea.neon.service.ProjectService;
import com.ea.neon.service.SkillService;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
public class ProjectController {

	@Autowired
	ProjectService projectService;
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	SkillService skillService;
	
	@ModelAttribute("userStory")
	public Project getProject() {
		return new Project();
	}

	@RequestMapping(value = "/products/all", method = RequestMethod.GET)
	public String listProjects(Model model) {
		model.addAttribute("category", categoryService.findAll());
		model.addAttribute("skill", skillService.findAll());
		model.addAttribute("listProject", projectService.findAll());
		return "project_read";
	}
	
	@ModelAttribute("projectSearch")
	public ProjectSearchDTO projectSearchDetails(){
		return new ProjectSearchDTO();
	}
	
	@RequestMapping(value = "/products/search", method = RequestMethod.GET)
	public String searchProjects(Model model,@RequestParam String search) {
		model.addAttribute("listProject", projectService.findByTitleAndDesc(search));
		return "project_read";
	}
	
	

	@RequestMapping(value = "/products/filterSearch", method = RequestMethod.POST)
	public String filterSearch(Model model,@ModelAttribute("projectSearch") ProjectSearchDTO projectSearchDTO) {
		CategoryTitle categoryTitle = projectSearchDTO.getCategory().getCategoryTitle();
		List<SkillTitle> skills = new ArrayList<>();
		for(Skills s: projectSearchDTO.getSkills()){
			skills.add(s.getSkillTitle());
		}
	
		Double maxBudget = projectSearchDTO.getMaxBudget();
				
		model.addAttribute("category", categoryService.findAll());
		model.addAttribute("skill", skillService.findAll());	
		model.addAttribute("listProject", projectService.findBySelection(skills, categoryTitle, 1.0, maxBudget));
		return "project_read";
	}
	
	@RequestMapping(value = "/products/searchFilter", method = RequestMethod.GET)
	public String searchProjectsByFilter(Model model,@RequestParam String skillTitles, 
			@RequestParam String categoryTitle, @RequestParam Double minBudget, @RequestParam Double maxBudget) {
		List<SkillTitle> skills = new ArrayList<>();
		skills.add(SkillTitle.fromString(skillTitles));
		model.addAttribute("listProject", projectService.findBySelection(skills, CategoryTitle.fromString(categoryTitle), minBudget, maxBudget));
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
