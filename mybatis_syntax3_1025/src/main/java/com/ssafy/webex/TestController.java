package com.ssafy.webex;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.webex.dto.Country;
import com.ssafy.webex.model.mapper.WorldMapper;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class TestController {

	@Autowired
	WorldMapper worldMapper;

	@GetMapping("/")
	public String test() throws SQLException {

		//		City city = new City();
		//        city.setName("도시");
		//        city.setCountryCode("KOR");
		//        city.setDistrict("도시");
		//        city.setPopulation(3000);

		//        int cnt = worldMapper.insertCity(city);
		//		log.debug("cnt : {}", cnt);//변경된 행의 개수
		//        
		//        log.debug("city 정보 : {}", city.toString());

		//        City city = new City();
		//        city.setName("NEW도시");
		//        city.setPopulation(100000000);
		//        worldMapper.updateLastCity(city);

		//모든 나라정보와 해당 나라의 수도정보 조회 (1:1 관계)
//        List<Country>  countries = worldMapper.selectCoCi();
//        for(Country country: countries) {
//            log.debug(country.toString());
//        }
        
        //모든 나라의 언어정보 조회 (1:N관계)
        List<Country>  countries = worldMapper.selectCoCl();
        for(Country country: countries) {
            log.debug(country.toString());
        }

		return null;
	}
}
