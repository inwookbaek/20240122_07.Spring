package com.lec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DemoApplication.class, args);
		// Spring Boot에서 Application 실행하는 3가지방법
		// 1. WebApplicationType.NONE : Java Application
		// 2. WebApplicationType.SERVLET : Web Application
		// 3. WebApplicationType.REACTIVE
		//    ... Spring 5.0에 추가된 비동기방식처리
		//    ... Non-Blocking IO를 지원하는 WebFlux를 적용할 때 사용
		
		SpringApplication application = new SpringApplication(DemoApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

}
