package com.ea.neon.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Project implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5180380150346197569L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private Double budget;

	private String description;

	@OneToOne(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn
	private Status status;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {  CascadeType.MERGE })
	@JoinColumn
	private List<Skills> skills;

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

	@ManyToMany(mappedBy = "projects", fetch = FetchType.EAGER, cascade = { CascadeType.MERGE })
	private List<Freelancer> freelancers;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE })
	@JoinColumn
	private Employer employer;

	@OneToOne(fetch = FetchType.EAGER, cascade = {  CascadeType.MERGE })
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
