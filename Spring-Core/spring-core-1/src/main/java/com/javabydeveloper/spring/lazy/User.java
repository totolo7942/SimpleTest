package com.javabydeveloper.spring.lazy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class User {
	
	@Lazy
	@Autowired
	private Student student;

	public User() {
		System.out.println("User Instance Created");
	}

	public Student getStudent() {
		return student;
	}
}
