package com.javabydeveloper.spring.autowire.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("contact")
public class ContactDao implements IDao {

	@Override
	public void result() {
		
		System.out.println("Contact Dao Implementation");
	}
}
