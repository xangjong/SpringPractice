package com.spring_mvc.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	@RequestMapping("/bookInfoView")
	public String bookInfoView() {
		return "book/bookInfoView";
	}
	
	@RequestMapping("/bookInfoView1")
	public String showBookInfo1(Model model) {
		model.addAttribute("title", "스프링 프레임워크1");
		model.addAttribute("price", 20000);
		return "book/bookInfoView";
	}
	
	@RequestMapping("/bookInfoView2")
	public ModelAndView showBookInfo2(ModelAndView mv) {
		
		mv.addObject("title", "스프링 프레임워크2");
		mv.addObject("price", 30000);
		mv.setViewName("book/bookInfoView");
		return mv;
	}
	
	// 다중 맵핑
	@RequestMapping(value= {"/book/bookInfoView3", "/book/bookInfoView4"})
	public String showBookInfo34(HttpServletRequest request, Model model) {
		// 경로 확인해서 경로에 따라 다르게 설정
		if(request.getServletPath().equals("/book/bookInfoView3")) {
			model.addAttribute("title", "스프링 프레임워크3");
			model.addAttribute("price", 33000);
		} else	if(request.getServletPath().equals("/book/bookInfoView4")) {
			model.addAttribute("title", "스프링 프레임워크4");
			model.addAttribute("price", 40000);
		}
		
		return "book/bookInfoView";
	}
}
