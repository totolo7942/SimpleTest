package com.javabydeveloper.spring.demo.importannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.config.importannotation.componentscan.ExampleComponent;
import com.javabydeveloper.spring.config.importannotation.testImportComponent.ImportComponentsConfig;

public class ImportComponetsConfigDemo {

	public static void main(String[] args) {
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(ImportComponentsConfig.class);
		String[] components = ctxt.getBeanDefinitionNames();

		for (String bean : components)
			System.out.println(bean);
	}
}
