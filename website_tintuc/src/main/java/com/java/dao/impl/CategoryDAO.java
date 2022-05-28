package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.ICategoryDAO;
import com.java.mapper.CategoryMapper;
import com.java.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {

	

	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}
}
	
	
