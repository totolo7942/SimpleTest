package com.javabydeveloper.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javabydeveloper.spring.autowire.service.DemoService;
import com.javabydeveloper.spring.autowire.service.ExampleService;
import com.javabydeveloper.spring.autowire.service.SampleService;

@Component
public class AutowireDITestService {

	// @Autowired on property
	@Autowired
	private DemoService demoService;

	private ExampleService exampleService;
	private SampleService sampleService;

	// @Autowired on setter

	@Autowired
	public void setExampleService(ExampleService exampleService) {
		this.exampleService = exampleService;
	}

	// @Autowired on constructor
	@Autowired
	public AutowireDITestService(SampleService sampleService) {
		this.sampleService = sampleService;
	}

	public void test() {
		System.out.println("\n ------ Autowiring Dependency Injection Results ------");
		demoService.demo();
		exampleService.example();
		sampleService.sample();
	}

}
