package com.spring_di_annotation_component;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class NameMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-context2.xml");
		// 오류 : pom.xml에 Spring 라이브러리 없어서 나는 오류
		// => pom.xml(스프링 설정 파일)에 Spring 라이브러리 추가
		
		NameController controller = context.getBean("nameController", NameController.class);
		// @Component 어노테이션을 사용하여 클래스의 빈을 등록했으므로 
		// getBean() 메소드를 가져다 사용
		
		controller.show("이몽룡");
		context.close();

	}

}
