package com.ssafy.mvc.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.dto.Car;
import com.ssafy.mvc.model.dao.CarDao;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	CarDao carDao;
	
	@Override
	public List<Car> selectAll() throws SQLException {
		return carDao.selectAll();
	}

	@Override
	public int regiCar(Car car) throws SQLException {
		// TODO Auto-generated method stub
		return carDao.regiCar(car);
	}

}
