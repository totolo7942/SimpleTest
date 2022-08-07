package com.javabydeveloper.spring.component;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Apple implements Fruit {

	@Override
	public String toString() {
		return "Apple";
	}
}
