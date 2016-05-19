package com.ea.neon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.neon.domain.Employer;
import com.ea.neon.domain.Project;

public interface EmployerRepository extends JpaRepository<Employer, Integer> {

	List<Employer> findByProject(List<Project> projects);
}
