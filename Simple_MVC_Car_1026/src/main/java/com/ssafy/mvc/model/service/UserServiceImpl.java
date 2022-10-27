package com.ssafy.mvc.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User login(User user) throws SQLException {
		
		return userMapper.login(user);
	}

	@Override
	public int signUp(User user) throws SQLException {
		// TODO Auto-generated method stub
		return userMapper.signUp(user);
	}
}
