package com.javabydeveloper.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javabydeveloper.spring.autowire.service.DemoService;
import com.javabydeveloper.spring.autowire.service.ExampleService;
import com.javabydeveloper.spring.autowire.service.SampleService;

@Component
public class AutowireCustomMethodDITestService {

	private DemoService demoService;
	private ExampleService exampleService;
	private SampleService sampleService;
	
	@Autowired
	public void initialize(DemoService demoService, ExampleService exampleService, SampleService sampleService) {
		this.demoService = demoService;
		this.exampleService = exampleService;
		this.sampleService = sampleService;
	}
	
	public void test() {
		System.out.println("\n ------ Autowiring Custom Method Results ------");
		demoService.demo();
		exampleService.example();
		sampleService.sample();
	}
}
