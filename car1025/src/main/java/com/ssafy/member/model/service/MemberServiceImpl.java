package com.ssafy.member.model.service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper memberMapper;
	
	// 회원 가입
	@Override
	public void join(MemberDto member) throws SQLException {
		memberMapper.join(member);
	}

	// 로그인
	@Override
	public MemberDto login(Map<String, String> map) throws SQLException {
		return memberMapper.login(map);
	}

}
