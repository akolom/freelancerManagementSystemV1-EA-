package com.ea.neon.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7996710154317542589L;

	@Id
	@GeneratedValue
	private Integer id;

	public enum CategoryTitle {
		WEBSITE_IT_AND_SOFTWARE, MOBILE_PHONES_AND_COMPUTING;
	};

	private CategoryTitle categoryTitle;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn
	private List<Skills> skills;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CategoryTitle getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(CategoryTitle categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public List<Skills> getSkills() {
		return skills;
	}

	public void setSkills(List<Skills> skills) {
		this.skills = skills;
	}

}
