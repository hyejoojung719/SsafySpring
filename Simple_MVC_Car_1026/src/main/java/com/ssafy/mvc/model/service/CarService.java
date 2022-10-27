package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.mvc.dto.Car;

public interface CarService {

	//전체 조회
	List<Car> selectAll() throws SQLException;
	
	//차 등록
	int insertCar(Car car) throws SQLException;
	
	//상세 조회
	Car selectByNumber(String number) throws SQLException;
	
}
