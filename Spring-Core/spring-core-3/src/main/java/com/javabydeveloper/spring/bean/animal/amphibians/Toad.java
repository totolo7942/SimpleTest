package com.javabydeveloper.spring.bean.animal.amphibians;

import org.springframework.stereotype.Component;

@Component
public class Toad implements Amphibian {

	@Override
	public String toString() {
		return "Toad";
	}	
}
