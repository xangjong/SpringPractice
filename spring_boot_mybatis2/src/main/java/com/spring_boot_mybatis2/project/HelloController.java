package com.spring_boot_mybatis2.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@ResponseBody
	@RequestMapping("/")
	public String home() {
		System.out.println("hello2 boot");
		return "hello2 boot";
	}
	
	@RequestMapping("/hello2")
	public String hello2(Model model) {
		model.addAttribute("message", "반갑습니다.");
		return "hello2";
	}
	
}
