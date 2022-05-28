package com.java.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;
	
	public HttpUtil(String value) {
		this.value = value;
	}
	
	
	//hàm này để ép kiểu dữ liệu của người dùng gửi lên, ép từ json sang string json
	public static HttpUtil of (BufferedReader reader) {
		StringBuilder sb = new StringBuilder();
		try {
			String line;
		    while ((line = reader.readLine()) != null) {
		        sb.append(line);
		    }
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		return new HttpUtil(sb.toString());
	}
	
	//hàm này dùng để mapping data(sau khi đã ép kiểu từ json sang string json)  với model tương ứng 
	//bằng cách sử dụng hàm ObjectMapper(). Muốn sử dụng hàm này thì phải khai báo dependency jackson-databind
	public <T> T toModel(Class<T> tClass) {
		try {
			return new ObjectMapper().readValue(value, tClass);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return null;
	}
	
}
