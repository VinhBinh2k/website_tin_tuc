package com.java.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.java.dao.ICategoryDAO;
import com.java.dao.impl.CategoryDAO;
import com.java.model.CategoryModel;
import com.java.service.ICategoryService;

public class CategoryService implements ICategoryService{

	
/*c1	
	private ICategoryDAO categoryDAO;
	
	public CategoryService() {
		categoryDAO = new CategoryDAO();
	}*/
	
//c2
	@Inject
	private ICategoryDAO categoryDAO;
	//khi sử dụng inject thì nó sẽ tự động khởi tạo  categoryDao = new CategoryDAO() mà không cần phải ghi ra 
	//Lý do sử dụng là khi có nhiều đối tượng cùng có chung 1 kiểu dữ liệu thì mỗi lần khai báo đối tượng ta
	//lại phải vào contructor để khởi tạo đối tượng đó vì vậy sử dụng inject để nó tự động khởi tạo cho chúng ta
	//và nó sẽ tự tìm đến cái hàm mà ta cần dùng.
	@Override
	public List<CategoryModel> findAll() {
		// TODO Auto-generated method stub
		
		return categoryDAO.findAll();
	}
	
}
