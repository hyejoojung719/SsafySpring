package com.ssafy.member.controller;

import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping(value = "/member")
@Slf4j
public class MemberController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	MemberService memberService;
	
	// 회원 가입 페이지로 이동
	@GetMapping("/join")
	public String goJoinPage() {
		return "/member/join";
	}
	
	// 로그인 페이지로 이동 
	@GetMapping("/login")
	public String goLoginPage() {
		return "/member/login";
	}
	
	// 회원가입
	@PostMapping("/join")
	public String join(@RequestParam("id") String id, 
			@RequestParam("pwd") String pwd) throws SQLException{
		
		MemberDto member = new MemberDto();
		member.setId(id);
		member.setPwd(pwd);
		
		memberService.join(member);
		return "redirect:/";
	}
	
	// 로그인
	@PostMapping("/login")
	public String login(@RequestParam("id") String id,
			@RequestParam("pwd") String pwd, HttpSession session) throws SQLException{
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		
		
		MemberDto member = memberService.login(map);
		if(member!=null) {
			// 사용자 존재
			session.setAttribute("memberInfo", member);
		}
		
		return "redirect:/";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
