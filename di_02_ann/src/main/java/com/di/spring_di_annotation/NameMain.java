package com.di.spring_di_annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class NameMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-context.xml");
		// 오류 : pom.xml에 Spring 라이브러리 없어서 나는 오류
		// => pom.xml(스프링 설정 파일)에 Spring 라이브러리 추가
		
		NameController controller = context.getBean("nameController", NameController.class);
		controller.show("홍길동");
		context.close();

	}

}
