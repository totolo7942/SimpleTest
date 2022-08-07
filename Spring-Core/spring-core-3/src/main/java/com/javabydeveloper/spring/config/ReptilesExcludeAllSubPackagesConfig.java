package com.javabydeveloper.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.javabydeveloper.spring.bean.animal.reptiles", 
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, 
		pattern = "com.javabydeveloper.spring.bean.animal.reptiles.*..*"))
public class ReptilesExcludeAllSubPackagesConfig {

}
