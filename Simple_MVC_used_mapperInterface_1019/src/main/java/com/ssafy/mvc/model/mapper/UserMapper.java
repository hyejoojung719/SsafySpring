package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.dto.User;

@Mapper
public interface UserMapper {

	User selectUser(HashMap<String, String > map) throws SQLException;
	
}
