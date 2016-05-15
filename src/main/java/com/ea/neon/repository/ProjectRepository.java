package com.ea.neon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.neon.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
