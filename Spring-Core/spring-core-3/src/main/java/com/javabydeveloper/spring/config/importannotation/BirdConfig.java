package com.javabydeveloper.spring.config.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javabydeveloper.spring.bean.animal.birds.Eagle;
import com.javabydeveloper.spring.bean.animal.birds.Ostrich;
import com.javabydeveloper.spring.bean.animal.birds.Peacock;

@Configuration
public class BirdConfig {

	@Bean
	public Eagle eagle() {
		return new Eagle();
	}
	
	@Bean
	public Ostrich ostrich() {
		return new Ostrich();
	}
	
	@Bean
	public Peacock peacock() {
		return new Peacock();
	}
}
