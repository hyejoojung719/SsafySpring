package com.ssafy.car.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.car.model.CarDto;
import com.ssafy.car.model.mapper.CarMapper;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarMapper carMapper;
	
	@Override
	public void regist(CarDto car) throws Exception {
		carMapper.regist(car);
		if(car.getFileInfo() != null) carMapper.insertFileInfo(car);
	}

	@Override
	public List<CarDto> selectAll() throws SQLException {
		return carMapper.selectAll();
	}
	

}
