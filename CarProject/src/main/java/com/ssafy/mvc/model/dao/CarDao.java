package com.ssafy.mvc.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Car;

public interface CarDao {

	List<Car> selectAll() throws SQLException;
	
	int regiCar(Car car) throws SQLException;
}
