package com.javabydeveloper.spring.component;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Mango implements Fruit {

	@Override
	public String toString() {
		return "Mango";
	}
}
