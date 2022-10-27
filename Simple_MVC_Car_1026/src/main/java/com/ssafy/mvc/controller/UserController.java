package com.ssafy.mvc.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	//로그인 화면 이동
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	//로그인 요청 처리
	@PostMapping("/login")
	public String login(User user, HttpSession session) throws SQLException {
		User userInfo = userService.login(user);
		//유저 정보가 있다면 session에 저장 후 메인 화면
		if(userInfo!=null) {
			session.setAttribute("userInfo", userInfo);
			return "redirect:/";
		}
		
		//유저 정보 없다면 로그인 화면
		return "redirect:/user/login";
	}
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) throws SQLException {
		//세션 초기화 후 메인 화면
		session.invalidate();
		return "redirect:/";
	}
	
	//회원 가입 페이지 이동
	@GetMapping("/signup")
	public String signup() {
		return "user/signup";
	}
	//회원 가입 요청
	@PostMapping("/signup")
	public String signup(User user) throws SQLException {
		
		userService.signUp(user);
		
		return "user/login";
	}
}
