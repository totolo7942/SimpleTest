package com.javabydeveloper.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.javabydeveloper.spring.config.AppConfigForLazy;
import com.javabydeveloper.spring.lazy.Customer;
import com.javabydeveloper.spring.lazy.Employee;
import com.javabydeveloper.spring.lazy.Student;
import com.javabydeveloper.spring.lazy.User;

public class ApplicationLazyConfigDemo {

	public static void main(String[] args) {
		ApplicationContext ctxt = new AnnotationConfigApplicationContext(AppConfigForLazy.class);

		Customer customer = ctxt.getBean(Customer.class);
		
		//User user = ctxt.getBean(User.class);
		
		//System.out.println(user.getStudent().getName());
	}
}
