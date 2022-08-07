package com.javabydeveloper.spring.bean.animal.amphibians;

import org.springframework.stereotype.Component;

@Component
public class Newt implements Amphibian {

	@Override
	public String toString() {
		return "Newt";
	}

	
}
