package com.ssafy.member.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.member.model.MemberDto;

@Mapper
public interface MemberMapper {

	// 회원 가입
	void join(MemberDto member) throws SQLException;
	
	// 로그인
	MemberDto login(Map<String, String> map) throws SQLException;
}
