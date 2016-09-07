package com.journaldev.spring.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Component
@Entity
@Table(name = "COUNTRY")
public class Country {
	
	@Id @GeneratedValue
	@Column(name = "country_id")
	private long countryId;
	
	@Column(name = "country_name")
	private String countryName;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
//	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	@Cascade(CascadeType.SAVE_UPDATE)
	@Fetch(FetchMode.JOIN)
    @BatchSize(size = 10)
	@JsonIgnore
	private Set<User> users;	
	/**********************************************************/
	
	public String getCountryName() {
		return countryName;
	}
	public long getCountryId() {
		return countryId;
	}
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	

	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	

}
