package com.javabydeveloper.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.javabydeveloper.spring.config.importannotation.componentscan.ExampleComponent;

public class ComponentsTestBean {

	@Autowired
	private ExampleComponent exampleComponent;
	
	public void printExampleComponent() {
		System.out.println(exampleComponent);
	}
	
}
