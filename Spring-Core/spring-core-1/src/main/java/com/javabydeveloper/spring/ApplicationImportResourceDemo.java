package com.javabydeveloper.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.config.AppConfigForXmlBeans;
import com.javabydeveloper.spring.importResource.ImportResourceDemoService;

public class ApplicationImportResourceDemo {

	private static ApplicationContext ctxt;

	public static void main(String[] args) {
		ctxt = new AnnotationConfigApplicationContext(AppConfigForXmlBeans.class);

		ImportResourceDemoService irds = ctxt.getBean(ImportResourceDemoService.class);
		irds.printBeans();

	}
}
