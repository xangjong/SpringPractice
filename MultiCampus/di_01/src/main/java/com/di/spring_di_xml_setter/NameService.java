package com.di.spring_di_xml_setter;

public class NameService {
	public String showName(String name) {
		System.out.println("NameService의 showName() 메소드");
		String myName = "내 이름은 " + name + " 입니다";
		return myName;
	}
}
