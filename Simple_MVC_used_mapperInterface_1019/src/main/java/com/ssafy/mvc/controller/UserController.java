package com.ssafy.mvc.controller;

import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.dto.User;
import com.ssafy.mvc.model.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("id") String id,
						@RequestParam("pwd") String pwd, HttpSession session) throws SQLException {
		
		HashMap<String, String > map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		User user = userService.selectUser(map);
		
		if(user != null) {
			// 로그인 성공
			session.setAttribute("userInfo", user);
			log.debug("세션 넣기 성공");
			return "home";
		}else {
			return "home";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("userInfo");
		return "home";
	}
}
