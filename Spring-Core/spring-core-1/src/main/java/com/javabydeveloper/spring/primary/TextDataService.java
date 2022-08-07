package com.javabydeveloper.spring.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TextDataService implements DataService {

	@Override
	public void printData() {
		System.out.println("Text Data");
	}

}
