package com.journaldev.spring.dao;

import java.util.List;
import java.util.Optional;

import com.journaldev.spring.model.User;

public interface UserDAO //extends CrudRepository<User, Serializable>
{
	public List<User> list();
	
	User findById(long id);
	
	Optional<User> findByName(String name, List<User> users);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(int id);

	List<User> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(User user);
}
