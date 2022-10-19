package com.ssafy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.mvc.dto.Car;
import com.ssafy.mvc.model.service.CarService;

@Controller
@RequestMapping(value="/car")
public class CarController {

	@Autowired
	CarService carService;
	
	@GetMapping("/list")
	public String showCarList(Model model) throws SQLException{
		List<Car> list = carService.selectAll();
		model.addAttribute("list", list);
		return "carList";
	}
	
	@GetMapping("/goRegi")
	public String goRegi() throws SQLException{
		return "carRegi";
	}
	
	@PostMapping("/regiCar")
	public ModelAndView RegiCar(@RequestParam("number") String number,
			@RequestParam("model") String model,
			@RequestParam("price") int price,
			@RequestParam("brand") String brand) throws SQLException{
		// 정보 받아오기 방법
		// 1. request.getParameter
		// 2. @RequestParam("a")
		// 3. modelAttribute
		
		Car car = new Car();
		car.setBrand(brand);
		car.setModel(model);
		car.setNumber(number);
		car.setPrice(price);
		
		carService.regiCar(car);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/car/list");
		
		return mv;
	}
}
