package com.spring_boot_mybatis_book.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.spring_boot_mybatis_book.project"})
@MapperScan(basePackages = {"com.spring_boot_mybatis_book.project"})
public class SpringBootMybatisBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisBookApplication.class, args);
	}

}
