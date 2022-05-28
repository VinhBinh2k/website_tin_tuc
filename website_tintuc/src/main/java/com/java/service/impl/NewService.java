package com.java.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.java.dao.INewDAO;
import com.java.model.NewModel;
import com.java.service.INewService;

public class NewService implements INewService {

	@Inject
	private INewDAO newDao; 
	
	@Override
	public List<NewModel> findCategoryById(Long categoryId) {
		return newDao.findCategoryById(categoryId);
	}

	@Override
	public NewModel save(NewModel newModel) {
		Long newId = newDao.save(newModel);
		return newDao.findOne(newId);
	}

	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew = newDao.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		newDao.update(updateNew);
		return newDao.findOne(updateNew.getId());
	}
	

}
