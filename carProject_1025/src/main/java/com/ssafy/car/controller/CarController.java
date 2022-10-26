package com.ssafy.car.controller;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.car.model.CarDto;
import com.ssafy.car.model.FileInfoDto;
import com.ssafy.car.model.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value="/car")
@Slf4j
public class CarController {

	@Autowired
	ServletContext servletContext;

	@Autowired
	CarService carService;

	// 차 등록 페이지 이동
	@GetMapping("/regist")
	public String goRegist() {
		return "/car/regist";
	}

	// 차 등록 하기
	@PostMapping("/regist")
	public ModelAndView regist(
			@RequestParam("number") String number,
			@RequestParam("model") String model,
			@RequestParam("price") int price,
			@RequestParam("brand") String brand,
			@RequestParam("upfile") MultipartFile file, 
			HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception{

		CarDto car = new CarDto();
		car.setBrand(brand);
		car.setModel(model);
		car.setNumber(number);
		car.setPrice(price);

		log.debug("차 정보 {},{},{},{}",car.getBrand(), car.getModel(), car.getNumber(), car.getPrice());

		if (!file.isEmpty()) {
			// 1. 파일 업로드
			// 파일 업로드할 경로
			String path = servletContext.getRealPath("/upload");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			File folder = new File(path+File.separator+today);

			// 해당 폴더가 없다면 만들기
			if(!folder.exists()) folder.mkdirs();

			//파일 저장
			//파일 업로드
			String originFile = file.getOriginalFilename();    //원본 파일 명
			//저장될 파일명 만들기
			String saveFile = UUID.randomUUID().toString() + originFile.substring(originFile.lastIndexOf('.'));
			// 파일 저장
			file.transferTo(new File(folder, saveFile));

			// 2. 파일 데이터 DB에 저장 
			FileInfoDto fileInfo = new FileInfoDto();
			fileInfo.setNumber(car.getNumber());
			fileInfo.setSaveFolder(today);
			fileInfo.setSaveFile(saveFile);
			fileInfo.setOriginFile(originFile);
			// 책 정보에 파일 데이터 추가
			car.setFileInfo(fileInfo);
		}

		carService.regist(car);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/car/list");

		return mv;

	}

	// 차 목록 페이지 이동
	@GetMapping("/list")
	public String goList(Model model) throws SQLException {
		List<CarDto> list = carService.selectAll();
		log.debug("차 개수 {}", list.size());
		model.addAttribute("list",list);
		return "/car/list";
	}

	// 차 상세 페이지 이동
	@GetMapping("/detail")
	public String detail(@RequestParam("number") String number, Model model) throws SQLException {
		log.debug("차번호 : {} ", number);
		CarDto car = carService.select(number);
		log.debug("차 정보 {}, {}, {}, {}, {}", car.getNumber(), car.getModel(), car.getPrice(), car.getBrand(), car.getFileInfo().getOriginFile());
		model.addAttribute("car", car);
		return "/car/detail";
	}


}
