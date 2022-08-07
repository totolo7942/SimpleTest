package com.javabydeveloper.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;

import com.javabydeveloper.spring.bean.animal.birds.Peacock;
import com.javabydeveloper.spring.bean.animal.fish.Guppy;
import com.javabydeveloper.spring.bean.animal.fish.Salmon;

public class ExampleBean {
	
	@Autowired
	private Salmon salmon;
	
	@Autowired
	private Guppy guppy;
	
	@Autowired
	private Peacock peacock;
	
	public void printObjects() {
		System.out.println("---------- Print ExampleBean Objects ----------");
		System.out.println(salmon);
		System.out.println(guppy);
		System.out.println(peacock);
	}
}
