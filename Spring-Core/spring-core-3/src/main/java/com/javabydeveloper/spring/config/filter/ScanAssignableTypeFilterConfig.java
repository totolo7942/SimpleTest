package com.javabydeveloper.spring.config.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.javabydeveloper.spring.bean.animal.amphibians.Amphibian;
import com.javabydeveloper.spring.bean.animal.reptiles.Crocodle;

@Configuration
@ComponentScan(basePackages = "com.javabydeveloper.spring.bean.animal",
        useDefaultFilters = false,
		includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
		classes = {Amphibian.class, Crocodle.class}))
public class ScanAssignableTypeFilterConfig {

}
