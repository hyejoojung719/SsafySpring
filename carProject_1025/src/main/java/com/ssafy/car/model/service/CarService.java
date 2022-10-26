package com.ssafy.car.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.car.model.CarDto;

public interface CarService {

	// 차 등록
	void regist(CarDto car) throws Exception;

	// 차 목록 불러오기
	List<CarDto> selectAll() throws SQLException;

	// 차 상세 
	CarDto select(String number) throws SQLException;
}
