package com.javabydeveloper.spring.component;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class Banana implements Fruit {

	@Override
	public String toString() {
		return "Banana";
	}
}
