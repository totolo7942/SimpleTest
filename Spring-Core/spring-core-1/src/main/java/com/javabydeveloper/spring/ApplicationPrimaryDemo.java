package com.javabydeveloper.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.config.AppConfigForPrimary;
import com.javabydeveloper.spring.primary.PrimaryDITestBean;

public class ApplicationPrimaryDemo {

	public static void main(String[] args) {
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfigForPrimary.class);

		PrimaryDITestBean pdits = ctxt.getBean(PrimaryDITestBean.class);
		pdits.printAnimal();
		pdits.printData();
		pdits.printBird();

		/*
		 * for(String bean : ctxt.getBeanDefinitionNames()) System.out.println(bean);
		 */
	}
}
