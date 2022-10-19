package com.ssafy.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
