package com.ssafy.mvc.model.service;

import java.sql.SQLException;

import com.ssafy.mvc.dto.User;

public interface UserService {

	User login(User user) throws SQLException;
	
	int signUp(User user) throws SQLException;
	
}
