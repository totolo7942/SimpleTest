package com.javabydeveloper.spring.config.importannotation.testImportComponent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.javabydeveloper.spring.bean.ComponentsTestBean;
import com.javabydeveloper.spring.config.importannotation.componentscan.ExampleComponent;

@Configuration
@Import(ExampleComponent.class)
public class ImportComponentsConfig {

	@Bean
	public ComponentsTestBean componentsTestBean() {
		return new ComponentsTestBean();
	}
}
