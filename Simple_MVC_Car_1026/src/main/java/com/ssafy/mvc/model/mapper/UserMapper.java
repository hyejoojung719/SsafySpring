package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.dto.User;

@Mapper
public interface UserMapper {

	//로그인
	User login(User user) throws SQLException;
	
	//회원가입
	int signUp(User user) throws SQLException;
	
}
