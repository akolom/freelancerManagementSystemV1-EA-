package com.ea.neon.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
public class Authority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4368824560841714481L;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private String role;

	@JsonIgnore
	@OneToOne(mappedBy = "authority", fetch = FetchType.LAZY)
	private Credentials credentials;

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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}
