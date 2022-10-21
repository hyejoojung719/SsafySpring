package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	UserMapper userMapper;
	
	@Override
	public User selectUser(HashMap<String, String > map) throws SQLException {
		return userMapper.selectUser(map);
	}

	
}
