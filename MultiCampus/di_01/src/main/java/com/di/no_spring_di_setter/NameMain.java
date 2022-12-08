package com.di.no_spring_di_setter;

public class NameMain {

	public static void main(String[] args) {
		// 외부에서 객체 생성
		NameService nameService = new NameService();
		NameController controller = new NameController();
		
		// 외부에서 만든 객체를 Setter 메소드를 통해서 주입
		// 의존성 주입
		controller.setNameService(nameService);
		controller.show("성춘향");
	}

}
