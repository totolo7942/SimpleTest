package com.javabydeveloper.spring.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.javabydeveloper.spring.importResource.ImportResourceDemoService;

@Configuration
@EnableAutoConfiguration
@ImportResource("classpath:beans-context.xml")
public class AppConfigForXmlBeans {
	
	@Bean
	public ImportResourceDemoService getImportResourceDemoService() {
		return new ImportResourceDemoService();
	}
}
