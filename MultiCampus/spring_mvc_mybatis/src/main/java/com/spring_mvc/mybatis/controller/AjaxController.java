package com.spring_mvc.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {

	// 로그인 폼 열기 요청 처리
	@RequestMapping("/loginForm")
	public String loginForm() {
		return "ajax/loginForm"; 
	}
	// 로그인 폼 열기 요청 처리 - 포워딩
	@RequestMapping("/loginForm2")
	public String loginForm2() {
		return "ajax/loginForm2"; 
	}
	
	// 로그인 처리
	// 아이디가 "abcd"이고 비밀번호가 "1234"인 경우에 "success",  아니면 "fail" 반환
	@ResponseBody
	@RequestMapping("/login")
	public String loginCheck(@RequestParam("id") String id,
							 @RequestParam("pw") String pw ) {
		
		System.out.println(id);
		System.out.println(pw);
		
		String result = "";
		if(id.equals("abcd") && pw.equals("1234"))
			result = "success";
		else
			result = "fail";
		
		return result;		
		// (1) @ResponseBody / Ajax 없는 경우
		// 여기서 result는 ? sucess.jsp  또는 fail.jsp 뷰 페이지 의미
		// 기존 방식 : 반환값이 뷰 페이지 이름이므로 sucess.jsp  또는 fail.jsp 파일을 찾음 -> 없으므로 404 오류
		
		// (2) @ResponseBody 만 있는 경우
		// 여기서 result는 ?  "sucess" 문자열 값 또는 "fail" 문자열 값
		//웹 페이지 body 로 응답 (뷰 페이지 없이 값 반환)

	}
}





