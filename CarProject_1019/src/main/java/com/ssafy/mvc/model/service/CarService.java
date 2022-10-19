package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Car;

public interface CarService {

	List<Car> selectAll() throws SQLException;
	
	int regiCar(Car car) throws SQLException;
}
