package com.ea.neon.service;

import java.util.List;

import com.ea.neon.domain.Category.CategoryTitle;
import com.ea.neon.domain.Employer;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills.SkillTitle;

public interface ProjectService {
public List<Project> findBySelection(List<SkillTitle> skillTitles, CategoryTitle categoryTitle, Double minBudget, Double maxBudget);
public List<Project> findByTitleAndDesc(String search);
public List<Project> findAll();
void saveProject(Project project);
List<Project> findAllByEmployer(Employer employer);

}
