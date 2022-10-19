package com.ssafy.mvc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.mvc.dto.Car;

@Repository
public class CarDaoImpl implements CarDao{

	@Autowired
	DataSource ds;
	
	@Override
	public List<Car> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select * from car";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			List<Car> list = new ArrayList<Car>();
			while(rs.next()) {
				Car car = new Car();
				car.setNumber(rs.getString(1));
				car.setModel(rs.getString(2));
				car.setPrice(rs.getInt(3));
				car.setBrand(rs.getString(4));
				list.add(car);
			}
			return list;
		} finally {
			// TODO: handle finally clause
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

	@Override
	public int regiCar(Car car) throws SQLException {
		// TODO Auto-generated method stub
	
		String sql = "insert into car values(?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, car.getNumber());
			pstmt.setString(2, car.getModel());
			pstmt.setInt(3, car.getPrice());
			pstmt.setString(4, car.getBrand());
			
			return pstmt.executeUpdate();
		} finally {
			// TODO: handle finally clause
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}
	}

}
