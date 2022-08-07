package com.javabydeveloper.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.javabydeveloper.spring.bean.animal.reptiles.crocodles.NileCrocodle;
import com.javabydeveloper.spring.bean.animal.reptiles.snakes.BlackMamba;

@Configuration
@ComponentScan(basePackages = "com.javabydeveloper.spring.bean.animal.reptiles",
        useDefaultFilters = false,
		includeFilters =  @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
        classes = {BlackMamba.class, NileCrocodle.class} ))
public class IncludeSpecificClassesConfig {

}
