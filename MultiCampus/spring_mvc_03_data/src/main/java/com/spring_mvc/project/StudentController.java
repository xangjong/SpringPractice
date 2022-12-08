package com.spring_mvc.project;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class StudentController {
	// index에서 studentForm 페이지 요청 처리
	@RequestMapping("/student/studentForm")
	public String studentFormView() {
		return "student/studentForm"; // student 폴더 안의 studentForm.jsp
	}
	
	@RequestMapping("/student/studentForm2")
	public String studentFormView2() {
		return "student/studentForm2"; // student 폴더 안의 studentForm.jsp
	}
	
	@RequestMapping("/student/studentForm3")
	public String studentFormView3() {
		return "student/studentForm3"; // student 폴더 안의 studentForm.jsp
	}
	
	@RequestMapping("/student/studentForm4")
	public String studentFormView4() {
		return "student/studentForm4"; // student 폴더 안의 studentForm.jsp
	}
	
	// View 페이지로부터 전달된 데이터 처리
	
	// (1) HttpServletRequest 클래스의 getParameter() 메소드 사용
	@RequestMapping("/student/newStudent")
	public String newStudent(HttpServletRequest request, Model model) {
		// form의 각 <input> 태그의 name 속성 값으로 전달된 값 받기
		String stdNo = request.getParameter("stdNo");
		String stdName = request.getParameter("stdName");
		String stdYear = request.getParameter("stdYear");
		
		// model로 설정 : view 페이지로 전달
		model.addAttribute("stdNo", stdNo);
		model.addAttribute("stdName", stdName);
		model.addAttribute("stdYear", stdYear);
		
		return "student/studentResult";
	}
	
	// (2) @RequestParam 어노테이션 사용
	@RequestMapping("/student/newStudent2")
	public String newStudent2(@RequestParam("stdNo") String stdNo,
							  @RequestParam("stdName") String stdName,
							  @RequestParam("stdYear") String stdYear,
							  Model model) {
		
		// Model로 설정
		model.addAttribute("stdNo", stdNo);
		model.addAttribute("stdName", stdName);
		model.addAttribute("stdYear", stdYear);
		
		return "student/studentResult";
	}
	
	// (3) Command 객체 사용
	@RequestMapping("/student/newStudent3")
	public String newStudent3(Student student) {
		System.out.println(student.getStdNo());
		System.out.println(student.getStdName());
		System.out.println(student.getStdYear());
		
		// Model 설정 필요 없음 : 자동으로 View의 Model에 등록
		
		return "student/studentResult3"; 
	}
	
	// (3) @ModelAttribute 어노테이션 사용 : 객체 이름 변경
	// View 페이지로 전달하는 Model 이름 변경
		@RequestMapping("/student/newStudent4")
		public String newStudent4(@ModelAttribute("stdInfo") Student student) {

			
			// Model 설정 필요 없음 : 자동으로 View의 Model에 등록
			
			return "student/studentResult4"; 
		}
		
		// url을 통한 데이터 전달
		@RequestMapping("/student/studentDetailView/{stdNo}")
		public String studentDetailView(@PathVariable String stdNo) {
			System.out.println(stdNo);
			return "index";
		}
		
		
		// 학생 검색 폼 요청 처리
		@RequestMapping("/student/studentSearchForm")
		public String studentSearchForm() {
			return "student/studentSearchForm"; // student 폴더 안의 studentSearchForm.jsp
		}
		
		// 학생 검색 : type과 keyword를 HashMap을 사용해서 받기
		@RequestMapping("/student/studentSearch")
		public String studentSearch(@RequestParam HashMap<String, Object> param, Model model) {
			// param에서 key로 value 추출해서 출력
			System.out.println(param.get("type"));
			System.out.println(param.get("keyword"));
			
			// DB에서 검색한 결과 받아왔다고 가정하고 ArrayList에 담아서 뷰 페이지로 전달
			// stdName "홍길동"으로 검색한 결과 2명 존재한다고 가정
			// 2021001 홍길동 2
			// 2022002 홍길동 1
			// (1) Student std1, std2 2개 생성 / Setter 사용해서 데이터 저장 (매개변수 있는 생성자 없음)
			Student std1 = new Student();
			//  Setter 사용해서 데이터 저장
			std1.setStdNo("2021001");
			std1.setStdName("홍길동");
			std1.setStdYear(2);
			
			Student std2 = new Student();
			// Setter 사용해서 데이터 저장
			std2.setStdNo("2022002");
			std2.setStdName("홍길동");
			std2.setStdYear(1);
			
			// (2) ArrayList에 add() 
			ArrayList<Student> stdList = new ArrayList<Student>();
			// std1, std2 추가
			stdList.add(std1);
			stdList.add(std2);
			
			// (3) Model 설정			
			model.addAttribute("stdList", stdList);
			
			return "student/studentSearchResult"; 
		}
	
}











