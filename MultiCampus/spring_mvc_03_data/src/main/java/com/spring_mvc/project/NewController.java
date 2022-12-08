package com.spring_mvc.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {
	
	@RequestMapping("/")
	public String index() {
		return "index"; // 뷰 페이지 이름 반환 : index.jsp
	}
	
	// 뷰 페이지로 데이터 전달
	// 'showInfo' 요청이 들어오면
	// Model 객체를 이용하여 데이터 설정 : key(이름)은 'name' value(값)은 "홍길동"
	// 뷰 페이지를 return하면 'showInfo' 뷰 페이지로 객체 전달됨
	
	@RequestMapping("/showInfo")
	public String showInfo(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", 30);
		return "showInfo"; // 뷰 페이지 이름 반환 : showInfo.jsp
			
	}
	
	@RequestMapping("/showInfo2")
	public ModelAndView showInfo2(ModelAndView mv) {
		mv.addObject("name", "홍길동");
		mv.addObject("address", "서울");
		mv.setViewName("showInfo2");
		
		return mv;
	}
	
	@RequestMapping("/showInfo3")
	public ModelAndView showInfo3(Model model, ModelAndView mv) {
		
		
		model.addAttribute("name", "이몽룡");
		
		mv.addObject("name", "성춘향"); // 동일 이름 name : 순서에 상관없이 ModelAndView가 우선
		mv.addObject("age", 25);
		mv.setViewName("showInfo3");
	
		model.addAttribute("address", "서울");
		
		return mv;
	}
	
	
	@RequestMapping("/newView")
	public String newView() {  // (3) 요청 처리 메소드 구현
		return "newView"; // 뷰페이지 이름 반환 : newView.jsp  // (4) 뷰 페이지 이름 반환
	}
}
