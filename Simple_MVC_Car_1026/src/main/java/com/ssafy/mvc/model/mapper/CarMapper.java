package com.ssafy.mvc.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.dto.Car;

@Mapper
public interface CarMapper {

	//전체 조회
	List<Car> selectAll() throws SQLException;
	
	//차 등록
	int insertCar(Car car) throws SQLException;
	//이미지 정보 등록
	int insertFileInfo(Car car) throws SQLException;
	
	//상세 조회
	Car selectByNumber(String number) throws SQLException;
	
}
