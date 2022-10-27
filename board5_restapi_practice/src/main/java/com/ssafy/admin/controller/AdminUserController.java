package com.ssafy.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RestController // 얘를 붙이면 따로 @responseBody를 붙이지 않아도 모든 return이 data
@RequestMapping("/admin")
public class AdminUserController {

	private MemberService memberService;
	
	public AdminUserController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("/user")
	// @ResponseBody를 붙이면 return 자체가 데이터가 됨(데이터 원본)
	// 넘겨야 할 것 => 1. data  ==> JSON
	//			   2. header->content type이 들어감 ==> application/JSON
	//			   3. status -> 200,201,404,500 ==> ResponseEntity<T>
	// ResponseEntity<?> => ? 아무거나 들어올 수 있게 한다.(모든 데이터 타입 받기)
	public /*@ResponseBody*/ ResponseEntity<?> /*String*/ userList() {
		try {
			List<MemberDto> list = memberService.listMember(null);	// --> json의 배열로 바꿔야 한다.(JSON Array)
			/* (기존)
			 * list를 갖고 json으로 보내야함
			 * json object와 json arrray 만들기
			 * */
			if(list != null && !list.isEmpty()) {
				//	목록을 얻어왔거나, 얻어왔는데 비어있지 않다면
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
				// list가 OK와 함께 넘어감
			}else {
				// 값이 없다.
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
				// 값이 없으니 Void 타입(객체니까V)
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 서버쪽에서 에러가 났다
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/user")
	// @RequestBody를 하면 알아서 넘어오는게 매칭된다.
	public ResponseEntity<?>  userModify(@RequestBody MemberDto memberDto) {
		try {
			memberService.modifyMember(memberDto);
			List<MemberDto> list = memberService.listMember(null);	
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/user/{userid}")
//	@GetMapping("/user/{userid}")
	//@GetMapping("/user/{userid}/{articleno}") 두 개 보내고 싶을 떄
	//fetch(`${root}/admin/user/${id}/100`)으로 넘어오면 @PathVariable("no") int no
	//fetch(`${root}/admin/user/${id}?no=100`)으로 넘어오면 @RequestParam("no") int no
	public ResponseEntity<?> userDelete(@PathVariable("userid") String userId) {
		try {
			memberService.deleteMember(userId);
			List<MemberDto> list = memberService.listMember(null);	
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("user/{userid}")
	public ResponseEntity<?> userView(@PathVariable("userid") String userId) {
		try {
			MemberDto memberDto = memberService.getMember(userId);
			if(memberDto != null) {
				return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);	// json만 return
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/user")
	// @RequestBody를 하면 알아서 넘어오는게 매칭된다.
	public ResponseEntity<?>  userJoin(@RequestBody MemberDto memberDto) {
		try {
			memberService.joinMember(memberDto);
			List<MemberDto> list = memberService.listMember(null);	
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	// alt + shift + m 눌러서 중복된 코드를 대체 가능
	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
