package com.ea.neon.domain;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "freelancer")
public class Freelancer extends User {

//	@Id
//	@GeneratedValue
//
//	private Integer freelancer_id;

	private Double charge;

	private Double jobCompleted;

	@OneToOne
	@JoinColumn(name = "freelancer_credentials")
	private Credentials credentials;

	@OneToMany
	@JoinColumn(name = "freelancer_experiances")
	private List<Experiance> experiances;

	@OneToMany
	@JoinColumn(name = "freelancer_education")
	private List<Education> educations;

	@ManyToMany
	@JoinTable
	private List<Project> projects;

	public List<Experiance> getExperiances() {
		return experiances;
	}

	public void setExperiances(List<Experiance> experiances) {
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

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

//	public Integer getFreelancer_id() {
//		return freelancer_id;
//	}
//
//	public void setFreelancer_id(Integer freelancer_id) {
//		this.freelancer_id = freelancer_id;
//	}

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
