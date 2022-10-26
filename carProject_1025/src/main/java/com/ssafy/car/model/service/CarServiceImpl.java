package com.ssafy.car.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.car.model.CarDto;
import com.ssafy.car.model.mapper.CarMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CarServiceImpl implements CarService{

	@Autowired
	CarMapper carMapper;
	
	@Override
	public void regist(CarDto car) throws Exception {
		carMapper.regist(car);
		log.debug("파일 정보 : {} ", car.getFileInfo());
		if(car.getFileInfo() != null) carMapper.insertFileInfo(car);
	}

	@Override
	public List<CarDto> selectAll() throws SQLException {
		return carMapper.selectAll();
	}

	@Override
	public CarDto select(String number) throws SQLException {
		return carMapper.select(number);
	}
	

}
