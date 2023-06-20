package com.zemoso.springbootassignment.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	It is the combination of @Configuration,@EnableAutoConfiguration
	and @ComponentScan.
*/
@SpringBootApplication
public class SpringBootAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignmentApplication.class, args);
	}
}
