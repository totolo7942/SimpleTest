package com.javabydeveloper.spring.autowire.dao;

import org.springframework.stereotype.Component;

@Component
public class CustomerDao implements IDao {

	@Override
	public void result() {
		System.out.println("Customer Dao Implementation");
	}
}
