package com.javabydeveloper.spring.autowire.dao;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDao implements IDao {

	@Override
	public void result() {
		
		System.out.println("Employee Dao Implementation");
		
	}
}
