package com.ea.neon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Skills {

	@Id
	@GeneratedValue
	private Integer id;
	
	public enum SkillTitle{
		JAVA, HTML_HTML5, PHP, JAVASCRIPT, MYSQL, C_PROGRAMMING, JQUERY,
		C_PLUS_PLUS, C_SHARP, PYTHON, ANDROID, GRAPHIC_DESIGN, SPRING_MVC; 
	};
	
	private SkillTitle skillTitle;
	
	

	public SkillTitle getSkillTitle() {
		return skillTitle;
	}

	public void setSkillTitle(SkillTitle skillTitle) {
		this.skillTitle = skillTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
