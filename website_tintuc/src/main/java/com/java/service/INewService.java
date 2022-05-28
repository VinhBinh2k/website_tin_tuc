package com.java.service;

import java.util.List;

import com.java.model.NewModel;

public interface INewService {
	 List<NewModel> findCategoryById(Long categoryId);
	 NewModel save(NewModel newModel);
	 NewModel update(NewModel updateNew);
}
