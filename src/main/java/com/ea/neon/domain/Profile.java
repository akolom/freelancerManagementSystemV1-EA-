package com.ea.neon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Profile {

	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String professionalHeadLine;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProfessionalHeadLine() {
		return professionalHeadLine;
	}

	public void setProfessionalHeadLine(String professionalHeadLine) {
		this.professionalHeadLine = professionalHeadLine;
	}

	public String getProfileSummary() {
		return profileSummary;
	}

	public void setProfileSummary(String profileSummary) {
		this.profileSummary = profileSummary;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	private String profileSummary;
	
	private Integer rank;
}
