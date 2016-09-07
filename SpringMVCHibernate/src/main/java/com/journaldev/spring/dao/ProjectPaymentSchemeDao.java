package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.ProjectModel;
import com.journaldev.spring.model.ProjectPaymentSchemeModel;

public interface ProjectPaymentSchemeDao {

	public void addProjectPaymentScheme(ProjectPaymentSchemeModel projectPaymentSchemeModel);
	public void updateProject(ProjectPaymentSchemeModel p);
	public List<ProjectPaymentSchemeModel> fetchPayementScheme();
	public ProjectModel getProjectsById(int id);
	public void deleteProject(int id);
}
