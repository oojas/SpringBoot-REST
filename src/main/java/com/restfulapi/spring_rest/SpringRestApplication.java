package com.restfulapi.spring_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRestApplication {

	public static void main(String[] args) {
		var ctx=SpringApplication.run(SpringRestApplication.class, args);
	}
}
