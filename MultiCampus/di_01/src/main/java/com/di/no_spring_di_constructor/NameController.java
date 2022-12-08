package com.di.no_spring_di_constructor;

// NameService 클래스이 showName() 메소드 사용
// new로 객체 직접 생성하지 않고
// 생성자를 통해서 외부에서 주입 받아서 사용
public class NameController {
	// new 직접 객체 생성하지 않음
	NameService nameService; 
	
	// 생성자를 통해서 NameService 객체 전달 받음
	// 의미 : 생성자를 통해 외부에서 주입 받음 (injection)
	// 의존성 주입
	public NameController(NameService nameService) {
		this.nameService = nameService;
	}

	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name) );
	}
}



