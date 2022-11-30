package com.di.spring_di_annotation;

public class AnotherNameService implements INameService {

	@Override
	public String showName(String name) {
		System.out.println("AnnotherNameService의 showName() 메소드");
		String myName = "나의 다른 이름은 " + name + "입니다.";
		return myName;
	}

}
