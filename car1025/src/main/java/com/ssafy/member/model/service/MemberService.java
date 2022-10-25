package com.ssafy.member.model.service;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.member.model.MemberDto;

public interface MemberService {

	// 회원가입
	void join(MemberDto member) throws SQLException;
	
	// 로그인
	MemberDto login(Map<String, String> map) throws SQLException;
	
}
