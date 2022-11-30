package com.di.no_spring_no_di;

public class NameMain {

	public static void main(String[] args) {
		// NameController 객체 생성하고 show() 메소드 호출하면서 이름 전달
		NameController controller = new NameController();
		controller.show("홍길동");
	}

}
