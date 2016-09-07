package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.Group;

public interface GroupDAO //extends CrudRepository<User, Serializable>
{
	public List<Group> list();
	
	Group findById(long id);
	
	Group findByName(String name);
	
	void saveGroup(Group group,int userId);
	
	void updateGroup(Group group);
	
	void deleteGroupById(int id);

	List<Group> findAllGroups(); 
	
	void deleteAllGroups();
	
	public boolean isGroupExist(Group group);

	List<Group> findAllWithUsers();

}
