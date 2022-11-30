package com.spring_mvc.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// (1) 클래스 생성하고 @Controller 붙이기
@Controller
public class NewController {
	// (2) @RequestMapping 어노테이션을 사용하여 요청 경로 지정
	// 'newView' 요청 처리
	@RequestMapping("/newView")
	public String newView() {	// (3) 요청처리 메소드 구현
		return "newView";		// (4) view페이지 이름 반환 : newView.jsp
	}
	
}
