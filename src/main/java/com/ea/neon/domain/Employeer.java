package com.ea.neon.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="employeer")
public class Employeer extends User {
//
//	@Id
//	@GeneratedValue
//	private Integer emp_id;
	
	private Integer projectCompleted;

	
	@ManyToOne
	@JoinColumn(name="employeer_project")
	private Project project;
	
	
	
	public Project getProject() {
		return project;
	}



	public void setProject(Project project) {
		this.project = project;
	}




//	public Integer getEmp_id() {
//		return emp_id;
//	}
//
//
//
//	public void setEmp_id(Integer emp_id) {
//		this.emp_id = emp_id;
//	}



	public Integer getProjectCompleted() {
		return projectCompleted;
	}

	public void setProjectCompleted(Integer projectCompleted) {
		this.projectCompleted = projectCompleted;
	}
	
	
}
