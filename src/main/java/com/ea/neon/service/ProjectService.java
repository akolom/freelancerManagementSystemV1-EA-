package com.ea.neon.service;

import java.util.List;

import com.ea.neon.domain.Employer;
import com.ea.neon.domain.Project;

public interface ProjectService {

	public void saveProject(Project project);

	public List<Project> findAllByEmployer(Employer employer);
	
}
