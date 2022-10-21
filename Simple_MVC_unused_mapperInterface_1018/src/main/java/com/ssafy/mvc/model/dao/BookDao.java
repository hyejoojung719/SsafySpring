package com.ssafy.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Book;

public interface BookDao {
	/**
	 * 책 전체 목록 조회 메소드
	 * @return 책 목록 반환
	 * @throws SQLException
	 */
	List<Book> selectAll () throws SQLException;
}
