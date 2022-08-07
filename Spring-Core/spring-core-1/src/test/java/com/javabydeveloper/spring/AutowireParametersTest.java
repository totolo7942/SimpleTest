package com.javabydeveloper.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.javabydeveloper.spring.autowire.service.DemoService;
import com.javabydeveloper.spring.autowire.service.ExampleService;
import com.javabydeveloper.spring.autowire.service.SampleService;
import com.javabydeveloper.spring.config.AppConfigForAutowired;

@SpringJUnitConfig(AppConfigForAutowired.class)
class AutowireParametersTest {

	private SampleService sampleService;

	// @Autowired on constructor parameters
	AutowireParametersTest(@Autowired SampleService sampleService) {
		this.sampleService = sampleService;
	}

	// @Autowired on method parameters
	@Test
	void injectServicesTest(@Autowired DemoService demoService,
			@Autowired(required = true) ExampleService exampleService) {

		demoService.demo();
		exampleService.example();
		sampleService.sample();
	}
}
