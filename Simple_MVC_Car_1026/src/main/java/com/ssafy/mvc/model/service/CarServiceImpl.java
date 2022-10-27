package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.mvc.dto.Car;
import com.ssafy.mvc.model.mapper.CarMapper;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarMapper carMapper;
	
	@Override
	public List<Car> selectAll() throws SQLException {
		return carMapper.selectAll();
	}

	@Override
	@Transactional
	public int insertCar(Car car) throws SQLException {
		carMapper.insertCar(car);
		if(car.getFileInfo()!=null) carMapper.insertFileInfo(car);
		return 1;
	}

	@Override
	public Car selectByNumber(String number) throws SQLException {
		return carMapper.selectByNumber(number);
	}

}
