package com.javabydeveloper.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.javabydeveloper.spring.bean.animal.reptiles",
        useDefaultFilters = false,
		includeFilters =  @ComponentScan.Filter(type = FilterType.REGEX,
        pattern = ".*(Cobra)" ))
public class IncludeSpecificClassesRegexConfig {

}
