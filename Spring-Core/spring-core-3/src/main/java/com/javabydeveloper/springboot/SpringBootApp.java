package com.javabydeveloper.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(SpringBootApp.class, args);

		String[] beans = ctxt.getBeanDefinitionNames();
		
		for(String bean : beans)
			System.out.println(bean);
	}
}
