package com.java.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.model.NewModel;

public class NewMapper implements RowMapper<NewModel>{

	@Override
	public NewModel mapRow(ResultSet resultSet) {
		NewModel news = new NewModel();
		try {
			news.setTitle(resultSet.getString("title"));
			news.setId(resultSet.getLong("id"));
			news.setContent(resultSet.getString("content"));
			news.setCategoryId(resultSet.getLong("categoryid"));
			return news;
		} catch (SQLException e) {
			return null;
		}
		
	}

	
}
