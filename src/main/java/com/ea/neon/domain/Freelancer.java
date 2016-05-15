package com.ea.neon.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "freelancer")
public class Freelancer extends User {

	private Double charge;

	private Double jobCompleted;

	@OneToMany
	@JoinColumn(name = "freelancer_experiances")
	private List<Experience> experiances;

	@OneToMany
	@JoinColumn(name = "freelancer_education")
	private List<Education> educations;

	@ManyToMany
	@JoinTable
	private List<Project> projects;
	
	@OneToMany
	@JoinColumn
	private List<Certifications> certifications;
	
	@OneToMany
	@JoinColumn
	private List<Skills> skills;

	public List<Experience> getExperiances() {
		return experiances;
	}

	public void setExperiances(List<Experience> experiances) {
		this.experiances = experiances;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public Double getCharge() {
		return charge;
	}

	public void setCharge(Double charge) {
		this.charge = charge;
	}

	public Double getJobCompleted() {
		return jobCompleted;
	}

	public void setJobCompleted(Double jobCompleted) {
		this.jobCompleted = jobCompleted;
	}

}
