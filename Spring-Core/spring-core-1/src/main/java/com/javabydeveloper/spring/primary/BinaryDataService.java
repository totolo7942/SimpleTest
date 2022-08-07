package com.javabydeveloper.spring.primary;

import org.springframework.stereotype.Component;

@Component
public class BinaryDataService implements DataService {

	@Override
	public void printData() {
		System.out.println("Binary Data");
	}

}
