package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.HashMap;

import com.ssafy.mvc.dto.User;

public interface UserService {

	User selectUser(HashMap<String, String > map) throws SQLException;
	
}
