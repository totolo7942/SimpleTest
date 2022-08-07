package com.javabydeveloper.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javabydeveloper.spring.autowire.dao.IUserDao;

@Component
public class AutowireByTypeTestService {

	@Autowired
	private IUserDao dao;
	
	public void printResults() {
		System.out.println("\n ------ Autowire By Type Results ------");
		dao.result();
	}
}
