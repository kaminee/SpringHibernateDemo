package com.journaldev.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "GROUPS")
public class Group {
	
	@Id
	@GeneratedValue
	@Column(name = "GROUP_ID")
    private long id;
    
    @Column(name = "GROUP_NAME")
    private String name;
 
    
    @ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(
            name = "USERS_GROUPS",
            joinColumns = @JoinColumn(name = "GROUP_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )
//    @JsonBackReference
    private Set<User> users = new HashSet<User>();
    
 /*   User usersArr;
    
    public User getUsersArr() {
		return usersArr;
	}

	public void setUsersArr(User usersArr) {
		this.usersArr = usersArr;
	}*/

	public Group() {
    }
 
    public Group(String name) {
        this.name = name;
    }
 
    public void addUser(User user) {
        this.users.add(user);
    }
 
//    @JsonIgnore
    public Set<User> getUsers() {
        return users;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty
	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public long getId() {
		return id;
	}

/*	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", users=" + users + "]";
	}*/
 
    // other getters and setters...
    
    
}