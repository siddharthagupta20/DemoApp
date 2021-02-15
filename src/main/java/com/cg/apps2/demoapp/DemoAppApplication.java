package com.cg.apps2.demoapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoAppApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(DemoAppApplication.class, args);
		log.info("Employee Payroll started in {} Environment ",context.getEnvironment().getProperty("environment"));
		log.info("Employee Payroll db User is: {}",context.getEnvironment().getProperty("spring.datasource.username"));
	}

}
