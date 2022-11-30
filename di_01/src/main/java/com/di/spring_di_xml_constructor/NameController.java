package com.di.spring_di_xml_constructor;

//  스프링에서의 XML 이용한 DI - 생성자 기반 DI
// NameService 클래스이 showName() 메소드 사용
// new로 객체 직접 생성하지 않고
// 생성자를 통해서 외부에서 주입 받아서 사용
public class NameController {
	// new 직접 객체 생성하지 않음
	NameService nameService; 
	
	// 생성자를 통해서 NameService 객체 전달 받음
	// 의미 : 생성자를 통해 외부에서 주입 받음 (injection)
	// 의존성 주입 
	// main()에서 객체를 생성해서 전달하는 것이 아니라
	// 컨테이너에서 가져온 빈을 전달해 줌
	
	public NameController(NameService nameService) {
		this.nameService = nameService;
	}

	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name) );
	}
}



