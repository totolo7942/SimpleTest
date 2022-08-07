package com.javabydeveloper.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import com.javabydeveloper.spring.bean.animal.reptiles.crocodles.DwarfCrocodle;
import com.javabydeveloper.spring.bean.animal.reptiles.snakes.BlackMamba;
import com.javabydeveloper.spring.bean.animal.reptiles.snakes.EgyptianCobra;

@Configuration
@ComponentScan(basePackages = "com.javabydeveloper.spring.bean.animal.reptiles",
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, 
	    classes = {BlackMamba.class, EgyptianCobra.class, DwarfCrocodle.class}))
public class ReptilesExcludeSpecificClassesConfig {

}
