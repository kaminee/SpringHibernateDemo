package com.journaldev.spring.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component

@Entity
@Table(name = "USERS")
public class User implements Serializable{
	
	
	@Id 
	@GeneratedValue
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "username")
	private String username;
	 
	@Column(name = "password")
	private String password;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	
	  
/*	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.LAZY )
    @JoinTable(name="COUNTRY",
        joinColumns = @JoinColumn(name="country_id"),
        inverseJoinColumns = @JoinColumn(name="country_id")
    )*/
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "country_id")
	private Country country;
	
//	@Fetch(FetchMode.SUBSELECT)

	@ManyToMany(targetEntity=Group.class, mappedBy="users",fetch=FetchType.EAGER)
	@JsonBackReference
	private Set<Group> groups = new HashSet<Group>();

//	@Column(updatable=false,insertable=false)
//	
	
//	@JsonIgnore
//	@JsonAnyGetter
	
    public Set<Group> getGroups() {
        return groups;
    }
	  
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@JsonProperty
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", address=" + address + ", country=" + country + ", groups=" + groups + "]";
	}

/*	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}
*/
	
}
