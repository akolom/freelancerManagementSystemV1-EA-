package com.ea.neon.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private Double budget;

	private String description;

	@OneToOne
	@JoinColumn
	private Status status;
	
	@ManyToMany(mappedBy = "projects")
	private List<Freelancer> freelancers;

	@ManyToOne
	@JoinColumn
	private Employer employer;
	
	
	@OneToOne
	@JoinColumn
	private Category category;

	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Freelancer> getFreelancers() {
		return freelancers;
	}

	public void setFreelancers(List<Freelancer> freelancers) {
		this.freelancers = freelancers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
