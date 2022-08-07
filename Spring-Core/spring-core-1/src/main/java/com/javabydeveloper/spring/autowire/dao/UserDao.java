package com.javabydeveloper.spring.autowire.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDao implements IUserDao {

	@Override
	public void result() {
		System.out.println("User Dao Implementation");
	}
}
