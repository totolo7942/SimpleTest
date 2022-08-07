package com.javabydeveloper.spring.importResource;

import org.springframework.beans.factory.annotation.Autowired;

import com.javabydeveloper.spring.bean.ExampleBean;
import com.javabydeveloper.spring.bean.SampleBean;

public class ImportResourceDemoService {

	@Autowired
	private ExampleBean exampleBean;
	
	@Autowired
	private SampleBean sampleBean;
	
	public void printBeans() {
		System.out.println(exampleBean);
		System.out.println(sampleBean);
	}
}
