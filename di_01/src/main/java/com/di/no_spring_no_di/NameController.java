package com.di.no_spring_no_di;

// NameService 클래스이 showName() 메소드 사용
public class NameController {
	// 필요한 곳에서 new 연산자를 사용해서 객체 직접 생성
	NameService nameService = new NameService(); 
	
	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name) );
	}
}

/*
	show() 메소드 
	- 이름을 인자로 입력 받아
	- NameService 클래스의 showName() 메소드를 호출하고
	- 결과를 받아서 출력
	- Controller 클래스에서 Service 클래스 객체 생성 
	-- DI 하지 않고 new 사용해서 직접 객체 생성
	
	
	여기서 NameController 클래스와 NameService가 강한 의존관계에 있음

*/

