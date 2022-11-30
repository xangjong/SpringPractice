package com.di.no_spring_di_constructor;

public class NameMain {

	public static void main(String[] args) {
		// 외부에서 객체 생성
		NameService nameService = new NameService();
		
		// 외부에서 생성된 객체를 생성자를 통해 주입 (injection)
		// 생성자를 이용한 의존성 주입
		NameController controller = new NameController(nameService);
		controller.show("이몽룡");

	}

}
