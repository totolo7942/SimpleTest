package com.javabydeveloper.spring.config.importannotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.javabydeveloper.spring.bean.ExampleBean;
import com.javabydeveloper.spring.bean.SampleBean;

@Configuration
@Import({FishConfig.class, BirdConfig.class})
public class ImportBeansConfig {

	@Bean
	public ExampleBean exampleBean() {
		return new ExampleBean();
	}
	
	@Bean
	public SampleBean sampleBean() {
		return new SampleBean();
	}
}
