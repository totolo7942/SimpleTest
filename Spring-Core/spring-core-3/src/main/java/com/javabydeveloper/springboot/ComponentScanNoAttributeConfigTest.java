package com.javabydeveloper.springboot;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.springboot.bean.animal.reptiles.ComponentScanNoAttributeConfig;

public class ComponentScanNoAttributeConfigTest {

	public static void main(String[] args) {
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(ComponentScanNoAttributeConfig.class);

		String[] springComponents = ctxt.getBeanDefinitionNames();

		for (String bean : springComponents)
			System.out.println(bean);
	}
}
