package com.ssafy.car.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.car.model.CarDto;

@Mapper
public interface CarMapper {
	// 차 등록
	void regist(CarDto car) throws Exception;
	void insertFileInfo(CarDto car) throws SQLException;

	// 차 목록 불러오기
	List<CarDto> selectAll() throws SQLException;

	// 차 상세 
}
