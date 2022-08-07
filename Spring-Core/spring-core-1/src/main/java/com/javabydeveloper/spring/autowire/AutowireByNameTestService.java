package com.javabydeveloper.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javabydeveloper.spring.autowire.dao.IDao;

@Component
public class AutowireByNameTestService {

	@Autowired
	private IDao employeeDao;
	
	@Autowired
	private IDao customerDao;
	
	public void printResults() {
		System.out.println("\n ------ Autowire By Name Results ------");
		employeeDao.result();
		customerDao.result();
	}
}
