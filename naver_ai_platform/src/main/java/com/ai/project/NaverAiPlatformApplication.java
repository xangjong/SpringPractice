package com.ai.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ai.project"})
public class NaverAiPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaverAiPlatformApplication.class, args);
	}

}
