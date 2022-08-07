package com.javabydeveloper.spring.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PrimaryDITestBean {

	@Autowired
	private Animal animal;

	@Autowired
	//@Qualifier("eagleBean")
	private Bird bird;

	@Autowired
	private DataService dataService;

	public void printData() {
		dataService.printData();
	}

	public void printAnimal() {
		System.out.println(animal);
	}

	public void printBird() {
		System.out.println(bird);
	}
}
