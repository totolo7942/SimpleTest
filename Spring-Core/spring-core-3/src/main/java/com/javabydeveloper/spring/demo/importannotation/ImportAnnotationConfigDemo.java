package com.javabydeveloper.spring.demo.importannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.bean.ExampleBean;
import com.javabydeveloper.spring.bean.SampleBean;
import com.javabydeveloper.spring.config.importannotation.ImportBeansConfig;

public class ImportAnnotationConfigDemo {

	public static void main(String[] args) {
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(ImportBeansConfig.class);

		ExampleBean exampleBean = ctxt.getBean(ExampleBean.class);
		SampleBean sampleBean = ctxt.getBean(SampleBean.class);
		
		exampleBean.printObjects();
		sampleBean.printObjects();
		
	}
}
