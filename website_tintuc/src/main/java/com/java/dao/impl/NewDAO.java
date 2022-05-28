package com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.java.dao.INewDAO;
import com.java.mapper.NewMapper;
import com.java.model.NewModel;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findCategoryById(Long categoryId) {
		String sql = "select * from news where categoryid = ?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel) {
		String sql = "insert into news(title, content, categoryId) values (?, ?, ?)";
		return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryId());
	}

	@Override
	public NewModel findOne(Long id) {
		String sql = "select * from news where id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql = new StringBuilder("UPDATE news SET title = ?, thumbnail = ?,");
		sql.append(" shortdescription = ?, content = ?, categoryid = ?,");
		sql.append(" createddate = ?, createdby = ? WHERE id = ?");
		update(sql.toString(), updateNew.getTitle(), updateNew.getThumbnail(), updateNew.getShortDescription(),
				updateNew.getContent(), updateNew.getCategoryId(), updateNew.getCreatedDate(), 
				updateNew.getCreatedBy(), updateNew.getId());

	}

}
