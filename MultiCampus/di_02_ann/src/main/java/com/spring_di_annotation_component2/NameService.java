package com.spring_di_annotation_component2;

import org.springframework.stereotype.Component;

// NameService 클래스를 빈으로 등록
// 생성된 빈 이름은 nameService

@Component
public class NameService implements INameService {

	@Override
	public String showName(String name) {
		System.out.println("NameService의 showName() 메소드");
		String myName = "내 이름은 " + name + "입니다.";
		return myName;
	}

}
