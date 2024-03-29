package com.ssafy.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.mvc.dto.Book;

//DAO 빈등록
@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public List<Book> selectAll() throws SQLException {
		return sqlSession.selectList("BookMapper.selectAll");
	}
	
	

//	//데이터소스 객체 주입
//	@Autowired
//	DataSource ds;
//	
//	@Override
//	public List<Book> selectAll() throws SQLException {
//		
//		String sql = "select isbn, title, author, price from book";
//		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		
//		try {
//			conn = ds.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			
//			rs = pstmt.executeQuery();
//			
//			List<Book> list = new ArrayList<Book>();
//			while(rs.next()) {
//				Book book = new Book();
//				book.setIsbn(rs.getString(1));
//				book.setTitle(rs.getString(2));
//				book.setAuthor(rs.getString(3));
//				book.setPrice(rs.getInt(4));
//				list.add(book);
//			}
//			return list;
//		} finally {
//			if(rs!=null) rs.close();
//			if(pstmt!=null) pstmt.close();
//			if(conn!=null) conn.close();
//		}
//	}

}
