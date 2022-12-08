package com.di.spring_di_xml_constructor_ex1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVMain {

	public static void main(String[] args) {
		// 스프링 컨테이너 객체 생성
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-context2.xml");
		
		TV tv = context.getBean("tv", TV.class);
		tv.volumeUp();
		tv.volumeDown();
		
		context.close();

	}

}
