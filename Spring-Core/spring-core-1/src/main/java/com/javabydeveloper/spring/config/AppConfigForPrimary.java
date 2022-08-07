package com.javabydeveloper.spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.javabydeveloper.spring.primary.Animal;
import com.javabydeveloper.spring.primary.Bird;
import com.javabydeveloper.spring.primary.Eagle;
import com.javabydeveloper.spring.primary.Peacock;
import com.javabydeveloper.spring.primary.PrimaryDITestBean;

@Configuration
@ComponentScan("com.javabydeveloper.spring.primary")
public class AppConfigForPrimary {
	
	@Bean
	public Animal tigerBean() {
		return new Animal("Tiger");
	}
	
	@Bean
	@Primary
	public Animal kangarooBean() {
		return new Animal("Kangaroo");
	}
	
	@Bean
	public Animal foxBean() {
		return new Animal("Fox");
	}
	
	@Bean
	@Primary
	@Qualifier("peacockBean")
	public Bird peacock() {
		return new Peacock();
	}
	
	@Bean
	@Qualifier("eagleBean")
	public Bird eagle() {
		return new Eagle();
	}
	
	@Bean
	public PrimaryDITestBean primariDITestBean() {
		return new PrimaryDITestBean();
	}
}
