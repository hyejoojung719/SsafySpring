package com.ssafy.webex.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.webex.dto.City;
import com.ssafy.webex.dto.Country;

public interface WorldMapper {
	int insertCity(City ci) throws SQLException;
	
	int selectLastCityId() throws SQLException;
	
	int updateLastCity(City city) throws SQLException;
	
	List<City> selectByCondition(Map<String, Object> condition) throws SQLException;
	
	List<Country> selectCoCi() throws SQLException;
	
	List<Country> selectCoCl() throws SQLException;
	
	List<Country> selectAllCountries() throws SQLException;
	
	List<City> selectCapital() throws SQLException;
}
