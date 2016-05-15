package com.ea.neon.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	private String budget;
	
	
	@ManyToMany(mappedBy="projects")
	private List<Freelancer> freelancers;
	
	

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

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}
	
	

}
