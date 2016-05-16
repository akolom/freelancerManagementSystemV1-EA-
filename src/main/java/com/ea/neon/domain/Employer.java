package com.ea.neon.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "employeer")
public class Employer extends User {

	private Integer projectCompleted;

	@OneToMany(mappedBy = "employer")
	private List<Project> project;

	public Integer getProjectCompleted() {
		return projectCompleted;
	}

	public void setProjectCompleted(Integer projectCompleted) {
		this.projectCompleted = projectCompleted;
	}

	public List<Project> getProject() {
		return project;
	}

	public void setProject(List<Project> project) {
		this.project = project;
	}

}
