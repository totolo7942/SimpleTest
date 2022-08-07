package com.javabydeveloper.spring.autowire;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javabydeveloper.spring.autowire.service.ExampleService;
import com.javabydeveloper.spring.autowire.service.ExerciseService;
import com.javabydeveloper.spring.autowire.service.ParadigmService;
import com.javabydeveloper.spring.autowire.service.SampleService;

@Component
public class OptionalDITestService {

	@Autowired(required = false)
	private ExerciseService exerciseService;
	
	@Autowired
	private Optional<ParadigmService> paradigmService;
	
	private Optional<ExampleService> exampleService;
	private SampleService sampleService;
	
	// to make only specific dependencies optional in constructor injection
	@Autowired
	public OptionalDITestService(Optional<ExampleService> exampleService,
			SampleService sampleService) {
		this.exampleService = exampleService;
		this.sampleService = sampleService;
	}


	public void doStuff() {
		System.out.println("\n ------ Autowiring Optional Dependency Injection Results ------");
		if(exerciseService != null)
			exerciseService.exercise();
		
		if(paradigmService.isPresent())
			paradigmService.get().paradigm();
		
		if(exampleService.isPresent())
			exampleService.get().example();
		
		sampleService.sample();
	}
	
}
