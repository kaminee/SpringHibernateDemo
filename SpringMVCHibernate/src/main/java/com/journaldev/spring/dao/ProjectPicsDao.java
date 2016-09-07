package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.ProjectPicsModel;

public interface ProjectPicsDao {

	public void addProjecPics(List<ProjectPicsModel> projPicModel);
	public List<ProjectPicsModel> fetchProjectsPicsById();
	public void deleteProjectPics(int id);
}
