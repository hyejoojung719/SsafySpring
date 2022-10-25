package com.ssafy.car.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
			@RequestParam("upfile") MultipartFile[] files, 
			HttpSession session,
			RedirectAttributes redirectAttributes) throws SQLException, IllegalStateException, IOException{

		CarDto car = new CarDto();
		car.setBrand(brand);
		car.setModel(model);
		car.setNumber(number);
		car.setPrice(price);
		
		if (!files[0].isEmpty()) {
			String realPath = servletContext.getRealPath("/upload");
//			String realPath = servletContext.getRealPath("/resources/img");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			String saveFolder = realPath + File.separator + today;
			File folder = new File(saveFolder);
			if (!folder.exists())
				folder.mkdirs();
			List<FileInfoDto> fileInfos = new ArrayList<FileInfoDto>();
			for (MultipartFile mfile : files) {
				FileInfoDto fileInfoDto = new FileInfoDto();
				String originalFileName = mfile.getOriginalFilename();
				if (!originalFileName.isEmpty()) {
					String saveFileName = UUID.randomUUID().toString()
							+ originalFileName.substring(originalFileName.lastIndexOf('.'));
					fileInfoDto.setSaveFolder(today);
					fileInfoDto.setOriginFile(originalFileName);
					fileInfoDto.setSaveFile(saveFileName);
					mfile.transferTo(new File(folder, saveFileName));
				}
				fileInfos.add(fileInfoDto);
			}
			car.setFileInfo(fileInfos);
		}
		
//		carService.regist(car);
		
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


}
