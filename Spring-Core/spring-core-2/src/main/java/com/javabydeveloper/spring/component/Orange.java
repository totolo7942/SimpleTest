package com.javabydeveloper.spring.component;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class Orange implements Fruit {

	@Override
	public String toString() {
		return "Orange";
	}
}
