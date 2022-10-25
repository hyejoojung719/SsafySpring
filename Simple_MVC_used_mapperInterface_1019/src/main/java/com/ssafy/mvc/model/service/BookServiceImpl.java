package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.dto.Book;
import com.ssafy.mvc.model.mapper.BookMapper;

import lombok.extern.slf4j.Slf4j;

// 빈 등록
@Service
@Slf4j
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookMapper bookMapper;

	@Override
	public List<Book> selectAll() throws SQLException {
		
		log.debug("ServiceImpl의 selectAll() 실행");
		
		return bookMapper.selectAll();
	}

	@Override
	@Transactional
	public void insertBook(Book book) throws SQLException {
		bookMapper.insertBook(book); // 책 정보가 먼저 등록 되어 있어야 함(그래야 isbn 이 있기 때문에)
		if(book.getFileInfo()!=null) bookMapper.insertFileInfo(book);
	}
	
	
}
