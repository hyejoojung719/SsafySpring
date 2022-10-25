package com.ssafy.webex;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.webex.dto.City;
import com.ssafy.webex.dto.Country;
import com.ssafy.webex.model.mapper.WorldMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j	//log 변수 사용
public class SyntaxTest {

	@Autowired
	WorldMapper worldMapper;
	
//	@Test
	public void test() {
		log.debug("test() 실행");
	}
	
//	@Test
//	@Transactional	//JUnit에서 사용 시 insert, update, delete 쿼리 테스트 후 DB 변경 상태가 초기화 됨
	public void insertTest() throws SQLException {
		City city = new City();
		city.setName("도시");
		city.setCountryCode("KOR");
		city.setDistrict("도시");
		city.setPopulation(3000);
		
		log.debug("쿼리 수행 전 도시 정보 : {}", city.toString());
		int result = worldMapper.insertCity(city);
		log.debug("쿼리 수행 후 도시 정보 : {}", city.toString());
		log.debug("쿼리 반환 결과 : {}", result);
		
//		int insertId = worldMapper.selectLastCityId();
//		log.debug("추가된 id : {}",insertId);
	}
	
//	@Test
	public void updateTest() throws SQLException {
		City city = new City();
//		city.setName("도시");
		city.setDistrict("수정된 도시");
//		city.setPopulation(3000);
		
		log.debug("쿼리 수행 전 도시 정보 : {}", city.toString());
		int result = worldMapper.updateLastCity(city);
		log.debug("쿼리 수행 후 도시 정보 : {}", city.toString());
		log.debug("쿼리 반환 결과 : {}", result);
	}

//	@Test
	public void selectByCondition() throws SQLException{
		//name, countrycode, district like 검색
		//population 은 해당 인구 이상 검색
		//key : 컬럼명, word : 검색 인자
		Map<String, Object> condition = new HashMap<>();
//		condition.put("key", "name");
//		condition.put("word", "Ku");
		condition.put("key", "population");
		condition.put("word", 10000000);
		
		List<City> cities = worldMapper.selectByCondition(condition);
		
		for(City city : cities) {
			log.debug(city.toString());
		}
	}
	
	@Test
	public void joinTest() throws SQLException{
		
		//모든 나라정보와 해당 나라의 수도정보 조회 (1:1 관계)
//		List<Country>  countries = worldMapper.selectCoCi();
//		for(Country country: countries) {
//			log.debug(country.toString());
//		}
		
		//모든 나라의 언어정보 조회 (1:N관계)
//		List<Country>  countries = worldMapper.selectCoCl();
//		for(Country country: countries) {
//			log.debug(country.toString());
//		}
		
		//모든 나라정보와 해당 나라의 수도정보 및 언어 정보 (1:1:N 관계)
//		List<Country>  countries = worldMapper.selectAllCountries();
//		for(Country country: countries) {
//			log.debug(country.toString());
//		}
		
		List<City> cities = worldMapper.selectCapital();
		for(City city: cities) {
			log.debug(city.toString());
		}
		
	}
	
}
