package com.javabydeveloper.spring.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.javabydeveloper.spring.autowire.dao.IDao;

@Component
public class AutowireByQualifierTestService {

	@Autowired
	@Qualifier("address")
	private IDao addressDao;
	
	@Autowired
	@Qualifier("contact")
	private IDao contactDao;
	
	public void printResults() {
		System.out.println("\n ------ Autowire By Qualifier Results ------");
		addressDao.result();
		contactDao.result();
	}
}
