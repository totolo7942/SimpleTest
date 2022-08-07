package com.javabydeveloper.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.config.AppConfigForLazyXmlConfig;
import com.javabydeveloper.spring.lazy.Person;

public class ApplicationLazyXmlConfigDemo {

	public static void main(String[] args) {
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfigForLazyXmlConfig.class);

		Person person = ctxt.getBean(Person.class);	
	}
}
