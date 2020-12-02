package com.school.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ConfigurationProperties
public class Assignment1Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Assignment1Application.class, args);
	}
	
}
