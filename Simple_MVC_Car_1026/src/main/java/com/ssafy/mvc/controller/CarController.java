package com.ssafy.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.mvc.dto.Car;
import com.ssafy.mvc.dto.FileInfo;
import com.ssafy.mvc.model.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	CarService carService;

	@Autowired
	ServletContext servletContext;

	//차 전체 조회
	@GetMapping("/list")
	public String list(Model model) throws SQLException {
		//DB에서 차 목록 조회
		List<Car> carList = carService.selectAll();
		//모델에 담기
		model.addAttribute("carList", carList);
		//뷰 반환
		return "car/carList";
	}

	//차 등록 페이지 이동
	@GetMapping("/insert")
	public String insertCar() {
		return "car/insertCar";
	}

	//차 등록 요청
	@PostMapping("/insert")
	public String insertCar(Car car, @RequestParam MultipartFile file) throws SQLException, IllegalStateException, IOException{

		//파일 정보 있을 때만 실행
		if(!file.isEmpty()) {
			//1. 파일 업로드
			//파일 업로드할 경로
			String path = servletContext.getRealPath("/upload");
			String today = new SimpleDateFormat("yyMMdd").format(new Date());
			File folder = new File(path+File.separator+today);
			//해당 폴더가 없다면 만들기
			if(!folder.exists()) folder.mkdirs();

			//파일 저장
			//파일 업로드
			String originFile = file.getOriginalFilename();	//원본 파일 명
			//저장될 파일명 만들기
			String saveFile = UUID.randomUUID().toString() + originFile.substring(originFile.lastIndexOf('.'));

			//2. 파일데이터 DB에 저장
			FileInfo fileInfo = new FileInfo();
			fileInfo.setNumber(car.getNumber());
			fileInfo.setSaveFolder(today);
			fileInfo.setSaveFile(saveFile);
			fileInfo.setOriginFile(originFile);
			//차 정보에 파일 데이터 추가
			car.setFileInfo(fileInfo);

			//DB에 차 정보, 파일 정보 등록
			carService.insertCar(car);
			//파일 업로드
			file.transferTo(new File(folder, saveFile));
		}
		else carService.insertCar(car);

		return "redirect:/car/list";
	}

	//차 상세정보 조회
	@GetMapping("/detail")
	public String detailCar(@RequestParam String number, Model model) throws SQLException{
		//DB에서 상세 정보 조회
		Car car = carService.selectByNumber(number);
		//차 정보 모델에 담기
		model.addAttribute("car", car);		
		//뷰 반환
		return "car/detailCar";
	}

	//이미지 파일 다운로드
	@ResponseBody
	@GetMapping("/download")
	public ResponseEntity<?> download(FileInfo fileInfo, HttpServletRequest request) throws Exception{


		String realPath = servletContext.getRealPath("/upload");

		String saveFolder = fileInfo.getSaveFolder();    //저장된 폴더명
		String saveFile = fileInfo.getSaveFile();        //저장된 파일명
		String originFile = fileInfo.getOriginFile();    //원본 파일명

		File file = new File(realPath + File.separator  + saveFolder, saveFile);

		//해당 파일이 존재하는 경우만
		if(file.exists()) {
			/////////브라우저에 따른 파일명 인코딩 처리//////
			String userAgent = request.getHeader("User-Agent");
			boolean isIE = userAgent.indexOf("MSIE") > -1 || userAgent.indexOf("Trident") > -1;
			String fileName = null;
			// IE는 다르게 처리
			if (isIE) fileName = URLEncoder.encode(originFile, "UTF-8").replaceAll("\\+", "%20");
			else fileName = new String(originFile.getBytes("UTF-8"), "ISO-8859-1");
			////////////////////////////////////////

			//헤더 설정 - 보낼 파일에 대한 정보 세팅
			HttpHeaders header = new HttpHeaders();
			header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+ fileName +"\"");    //사용자 쪽에서 파일 다운로드 창 뜨도록 헤더 설정
			header.setContentLength(file.length());    //컨텐츠의 길이 설정
			header.setContentType(MediaType.APPLICATION_OCTET_STREAM);    //바이너리 데이터로 받아오기    

			//URL로부터 정보 받아오기
			Resource resource = new UrlResource(file.toURI());


			return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
		}
		//파일이 존재하지 않는 경우
		else return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
