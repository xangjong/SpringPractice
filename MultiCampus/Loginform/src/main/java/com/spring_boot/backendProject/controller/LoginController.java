package com.spring_boot.backendProject.controller;


import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.backendProject.service.MemberService;


@Controller
public class LoginController {
	@RequestMapping("/")
	public String loginFormView() {
		return "/loginForm";
	}
	
	@Autowired
	MemberService memService;
	
	@ResponseBody
	@RequestMapping("/login")
	public String longinCheck(@RequestParam HashMap<String, Object> param, 
		HttpSession session) {
		
	// 로그인 체크 결과 : 아이디와 비밀번호 전달하고 로그인 성공하면 아이디 반환	
	String id = memService.loginCheck(param);
	String result="fail";
	
	// 아이디와 비밀번호 일치하면
	if(id !=null) {
		// 로그인 성공하면 세션 지정 
		session.setAttribute("sid", id);
		result ="success";
	}
		return result;
	}
}
