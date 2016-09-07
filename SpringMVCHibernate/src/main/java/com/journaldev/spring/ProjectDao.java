package com.journaldev.spring;

import java.util.List;

import com.journaldev.spring.model.ProjectModel;

public interface ProjectDao {

	public void addProject(ProjectModel projModel);
	public void updateProject(ProjectModel p);
	public List<ProjectModel> listProjects();
	public ProjectModel getProjectsById(int id);
	public void deleteProject(int id);
}
