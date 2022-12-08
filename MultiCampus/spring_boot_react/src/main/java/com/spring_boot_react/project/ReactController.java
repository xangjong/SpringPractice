package com.spring_boot_react.project;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactController {
	
	@GetMapping("hello")
	public String hello() {
		return "안녕하세요";
	}
}
