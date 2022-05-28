package com.java.dao;

import java.util.List;

import com.java.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel>{
	NewModel findOne(Long id);
	List<NewModel> findCategoryById(Long categoryId);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
}
