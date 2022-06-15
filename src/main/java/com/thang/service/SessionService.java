package com.thang.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
	@Autowired
	HttpSession session;
	/*
	 * Đọc giá trị của attribute trong session
	 * @param name tên attribute
	 * @return giá trị đọc được hoặc nu nếu không tồn tại
	 */
	
	public <T> T get(String name) {
		return (T)session.getAttribute(name);
	}
	
	public <T> T get(String name, T defaultVaue) {
		T value = get(name);
		return value != null ? value : defaultVaue;
	}
	
}
