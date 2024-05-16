package com.lec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Sb01BoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sb01BoardApplication.class, args);
	}

}
