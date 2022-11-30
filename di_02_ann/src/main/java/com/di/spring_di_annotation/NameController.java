package com.di.spring_di_annotation;

import javax.annotation.Resource;

public class NameController {
	// nameService bean을 자동으로 주입(DI 설정)
	// INameService 인터페이스를 구현한 클래스가 2개이므로
	// @Qualifier("bean 이름") 사용해야함
	// @Autowired 
	// @Qualifier("anotherNameService")
	// @Qualifier("bNameService")
	
	@Resource(name="anotherNameService")
	INameService nameService;
	
	// setter 메소드를 통해서 주입받음
	public void setNameService(INameService nameService) {
		this.nameService = nameService;
	}	

	public void show(String name) {
		System.out.println("NameController : " + nameService.showName(name) );
	}

	
}
