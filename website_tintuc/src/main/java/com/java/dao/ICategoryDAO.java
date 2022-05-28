package com.java.dao;

import java.util.List;

import com.java.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	List<CategoryModel> findAll();
}
