package com.ea.neon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ea.neon.domain.Category.CategoryTitle;
import com.ea.neon.domain.Employer;
import com.ea.neon.domain.Freelancer;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills.SkillTitle;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	@Query("select p from Project p where p.category.categoryTitle = ?1  and p.budget between ?2 and ?3")
	List<Project> findBySelections(CategoryTitle categoryTitle, Double minBudget, Double maxBudget);

	List<Project> findAllByEmployer(Employer employer);

}
