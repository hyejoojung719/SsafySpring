package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;

import com.ssafy.mvc.dto.User;

public interface UserMapper {

	User selectUser(HashMap<String, String > map) throws SQLException;
	
}
