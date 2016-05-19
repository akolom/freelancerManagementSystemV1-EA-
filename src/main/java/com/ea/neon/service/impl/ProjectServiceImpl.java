package com.ea.neon.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ea.neon.domain.Employer;
import com.ea.neon.domain.Freelancer;
import com.ea.neon.domain.Project;
import com.ea.neon.repository.FreelancerRepository;
import com.ea.neon.repository.ProjectRepository;
import com.ea.neon.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private FreelancerRepository freelancerRepository;

	@Override
	public void saveProject(Project project) {
		projectRepository.save(project);
	}

	@Override
	public List<Project> findAllByEmployer(Employer employer) {
		List<Project> projects = projectRepository.findAllByEmployer(employer);

		for (Project project : projects) {
			project.setFreelancers(freelancerRepository.findAllByProjectsId(project.getId()));
			for (Freelancer f : project.getFreelancers()) {
				f.setProjects(projectRepository.findAllByFreelancers(Arrays.asList(f)));
			}
		}

		return projects;
	}

	@Override
	public Project getProjectById(Integer projectId) {
		Project project = projectRepository.findOne(projectId);
		project.setFreelancers(freelancerRepository.findAllByProjectsId(projectId));
		return project;
	}

	@Override
	public void updateProject(Project project) {
		projectRepository.save(project);
	}

}
