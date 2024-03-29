package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Book;

public interface BookService {

	List<Book> selectAll() throws SQLException;
	
	void insertBook(Book book) throws SQLException;
	
}
