package com.javabydeveloper.spring.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class Student {

	public Student() {
		System.out.println("Student Instance Created");
	}
	
	private String name;

	public String getName() {
		return name;
	}
}
