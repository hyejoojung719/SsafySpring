package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Book;

public interface BookMapper {

	//	책 목록 전체 조회
	List<Book> selectAll() throws SQLException;
	
	// 책 정보 담기
	void insertBook(Book book) throws SQLException;
	void insertFileInfo(Book book) throws SQLException;
}
