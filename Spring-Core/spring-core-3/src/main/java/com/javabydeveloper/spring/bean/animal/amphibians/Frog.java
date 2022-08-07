package com.javabydeveloper.spring.bean.animal.amphibians;

import org.springframework.stereotype.Component;

@Component
public class Frog implements Amphibian {

	@Override
	public String toString() {
		return "Frog";
	}	
}
