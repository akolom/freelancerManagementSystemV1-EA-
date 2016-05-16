package com.ea.neon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Status {

	@Id
	@GeneratedValue
	private Integer id;
	
	
	public enum ProjectStatus{
		CALL_FOR_INTERVIEW,
		DECLINED,
		PENDING;
	};
	
	private ProjectStatus projectStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProjectStatus getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	
}
