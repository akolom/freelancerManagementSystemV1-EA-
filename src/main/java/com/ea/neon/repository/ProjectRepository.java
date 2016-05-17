package com.ea.neon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ea.neon.domain.Category.CategoryTitle;
import com.ea.neon.domain.Employer;
import com.ea.neon.domain.Project;
import com.ea.neon.domain.Skills.SkillTitle;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	@Query("select p from Project p where p.id in "
			+ "(select p1.id from Project p1 inner join p1.category.skills s where s.skillTitle in ?1 )"
			+ " and "
			+ "p.id in (select p2.id from Project p2 where p2.category.categoryTitle = ?2  and p2.budget between ?3 and ?4)")
	List<Project> findBySelections(List<SkillTitle> skillTitles,CategoryTitle categoryTitle, Double minBudget, Double maxBudget);

	List<Project> findAllByEmployer(Employer employer);

	@Query("select p from Project p inner join p.category.skills s where s.skillTitle in ?1")
	List<Project> findBySkillTitles(List<SkillTitle> skillTitles);
	
	@Query("select p from Project p where p.name like %?1% or  p.description like %?1%")
	List<Project> findByDescAndTitle(String search);
		
}
