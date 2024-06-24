package com.lec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lec08RedisApplication {

	private static final Log LOG = LogFactory.getLog(Lec08RedisApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Lec08RedisApplication.class, args);
	}

}
