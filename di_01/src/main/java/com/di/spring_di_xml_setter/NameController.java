package com.di.spring_di_xml_setter;

// Spring DI : XML을 이용한 DI - Setter 기반 DI
// NameService 클래스이 showName() 메소드 사용
// new로 객체 직접 생성하지 않고
// 생성자를 통해서 외부에서 주입 받아서 사용
public class NameController {
	// new 직접 객체 생성하지 않음
	NameService nameService;

	// 생성자 없음
	// Setter 메소드를 통해 외부에서 주입 받음 (injection)
	// 의존성 주입
	public void setNameService(NameService nameService) {
		this.nameService = nameService;
	}	

	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name) );
	}

}



