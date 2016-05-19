package com.ea.neon.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Status implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6613657980527314974L;

	@Id
	@GeneratedValue
	private Integer id;

	public enum ProjectStatus {
		CALL_FOR_INTERVIEW, DECLINED, PENDING, ACCEPTED;
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
