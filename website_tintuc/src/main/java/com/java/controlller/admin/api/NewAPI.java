package com.java.controlller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.model.NewModel;
import com.java.service.INewService;
import com.java.service.impl.NewService;
import com.java.utils.HttpUtil;


@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet{
	
	@Inject
	private INewService newService;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");//khi client có data là json gửi đến server trong data đó có tiếng việt 
										 //và để không bị lỗi font thì ta phải set như thế này cho nó
		
		resp.setContentType("application/json");
		// khi server xử lý tất cả mọi thứ xong rồi, nó trả kết quả về cho client và cụ thể data trả về là dạng json
		//thì để client có thể hiểu được cái data này là kiểu json thì server cũng phải định nghĩa là application/json
		//bằng cú pháp setContentType("application/json") như trên
		
		NewModel newModel =  HttpUtil.of(req.getReader()).toModel(NewModel.class);
		//data đc ép kiểu từ json sang string json sau đó map với model tương ứng. Thực hiện gọi 2 hàm đó xong
		//mình sẽ gán cái model vừa được map data vào 1 đối tượng thuộc kiểu model đó
		
		newModel = newService.save(newModel);
		//mình gọi hàm save từ class NewService và truyền vào đối tượng đã lưu data để add đối tượng này
		//vào database
	
		mapper.writeValue(resp.getOutputStream(), newModel);							
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		NewModel updateNew =  HttpUtil.of(req.getReader()).toModel(NewModel.class);
		updateNew = newService.update(updateNew);
		mapper.writeValue(resp.getOutputStream(), updateNew);
		
	}
//	
//	@Override
//	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//	}
	
	private void saveOrUpdate() {
		
	}
}
