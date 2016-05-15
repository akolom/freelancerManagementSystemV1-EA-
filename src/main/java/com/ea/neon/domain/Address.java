package com.ea.neon.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Address {
@Id
@GeneratedValue
private Integer id;

private String city;

private String state;

private String zip;

private String country;

private String street;

@ManyToOne
@JoinColumn(name="address_user")
private User user;

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}



}